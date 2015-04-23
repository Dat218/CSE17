/*
CSE 17
Daniel Truong
862607977
Program #3 DEADLINE: March 26, 2015
Program Description: Online Store
The store practices the use of composition since without a store, the other classes are useless.
The store will be responsible for calling the addItem method to create a product object and 
making the transaction between the customer and business possible. 
*/ 
public class Store {
	private Inventory inventory; //Allows Store to interact with Inventory class
	private double totalSales;
	
	/* Creates an Store object that includes the store's inventory and the total sales generated from its orders
	 * Initializes inventory to null and totalSales to 0 to begin. 
	 * Will later add more products into its inventory and generate more cash (hopefully). 
	 */
	public Store() {
		this.inventory = new Inventory();
		this.totalSales = 0;
	}
	
	//Self explanatory, just adds inventory to product by calling the addItem method in Inventory Class
	public void addItem(Product product, int qty) {
		this.inventory.addItem(product, qty);
	}
	
	/* This method will add together the cost of the transaction.
	 * In order to do that, the method will need to have a Product variable in order to invoke the getPrice method. 
	 * With the required information, the program can finally calculate the cost of the transaction. 
	 */
	public double getOrderTotal(Order newOrder) {
		InventoryItem item = this.inventory.lookupItem(newOrder.getSerialNumber());
		Product product = item.getProduct();
		double price = product.getPrice();
		double finalPrice = price * newOrder.getQty();
		return finalPrice;
	}
	
	public double getTotalSales() {
		return (this.totalSales*100)/100;
	}
	
	/* This method will first check to make sure the there is enough stock in the inventory to make the transaction.
	 * Then it will decrease the stock by the amount the customer is requesting.
	 * And it will add the cost of the order to the totalSales generated thus far.
	 * Finally, this method will print out the details of the order if successful.
	 * If not successful, it'll just print whatever it says in the else statement and not do any of the above. 
	 */
	public boolean makeSale(Order newOrder) {
		try {
			if (this.inventory.checkInventory(newOrder.getSerialNumber(), newOrder.getQty()) == true) {
				this.inventory.decreaseStock(newOrder.getSerialNumber(), newOrder.getQty());
				this.totalSales += getOrderTotal(newOrder);
				System.out.printf("Sold %d unit(s) of item #%s to %s \n", newOrder.getQty(), newOrder.getSerialNumber(), newOrder.getCustomer());
				return true;
			}
			else {
				System.out.printf("Insufficient inventory to process order of %d units of item %s from %s \n", newOrder.getQty(), newOrder.getSerialNumber(), newOrder.getCustomer());
				return false;
			}
		} catch(NullPointerException ex) {
			System.out.println("Sorry for the inconvenience. We do not carry this product in our inventory. You're going to have add this product into the main method if you want it");
		}
		return false;
	}
	
	// This method invokes the list method in the Inventory class to output the inventory 
	public void showInventory() {
		System.out.println("Inventory\n-------------");
		this.inventory.list();
	}
	
	
}
