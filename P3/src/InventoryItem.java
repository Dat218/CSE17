/*
CSE 17
Daniel Truong
862607977
Program #3 DEADLINE: March 26, 2015
Program Description: Online Store
This class, when an instance is created, represents a specific item in the inventory and also includes its quantity
Interacts with the Inventory class to provide that instance with the proper details
*/ 
public class InventoryItem {
	private int qty;
	private Product product;
	
	/* This InventoryItem constructor is to create an instance of InventoryItem which 
	 * specifies the type and quantity of the item, initializing these two variables
	 */
	public InventoryItem(Product product, int qty) {
		this.product = product;
		this.qty = qty;
	}
	
	/* Creates a sentence containing with the product's specific details, including the
	 * serial number, description, and quantity of the product. 
	 * Used to display the inventory
	 */
	public String getListing() {
		String list = "";
		return list += getSerialNumber() + "\t" + getProduct().getDescription() + "\t" +getQty();
	}
	
	
	public Product getProduct() {
		return this.product; 
	}
	
	public int getQty() {
		return this.qty;
	}

	/* Product already has an initialized serial number
	 * This method is able to return the serial number of the product by using the this.product keyword
	 * It allows the program to go into the Product class and fetch the serial number of the product from the 
	 * getSerialNumber() method. 
	 */
	public int getSerialNumber() {
		return this.product.getSerialNumber();
	}
	
	/* Invoked following the successful transaction of a product
	 * Just decreases the quantity(qyt) of specific instance.
	 */
	public void removeFromQty(int reduction) {
		this.qty -= reduction;
	}
}
