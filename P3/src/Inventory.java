/*
CSE 17
Daniel Truong
862607977
Program #3 DEADLINE: March 26, 2015
Program Description: Online Store
The Inventory class represents the entire inventory of the store that consists of InventoryItems organized in an arraylist.
Contains all information of the inventory and will execute specific tasks in each method when invoked upon.
*/ 
import java.util.ArrayList;
public class Inventory {
	private ArrayList<InventoryItem> items;
	
	//Automatically initializes the arraylist to be null
	public Inventory() {
		this.items = new ArrayList<InventoryItem>();
	}
	
	//Adds object to the items arraylist
	public void addItem(Product p, int qty) {
		this.items.add(new InventoryItem(p, qty));
	}
	
	/* This method will first find which product has the same serial number as the one being passed in the argument
	 * Then it will check to see if they have a large enough quantity to satisfy the customers request using an if statement.
	 * Returns true if there is enough, false if there is a shortage.
	 * Try catch is implemented in the case there is no such product in the inventory that is being requested by customer.
	 */
	public boolean checkInventory(int serialNumber, int qty) {
		InventoryItem item = lookupItem(serialNumber); //Created item variable to store the inventoryItem that contained the specific serialNumber 
		if (item.getQty() >= qty) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void decreaseStock(int serialNumber, int reduction) {
		for (InventoryItem item : this.items) {
			if (item.getSerialNumber() == serialNumber) {
				item.removeFromQty(reduction);
			}
		}
	}
	
	/* Method creates a list of the products in the inventory 
	 * Outputs the serial number, description, and quantity of product in specific format
	 * Calls the Product class's getListing method to obtain product details
	 */
	public void list() {
		for (InventoryItem product : this.items) {
			System.out.println(product.getListing());
		}
	}
	
	/* Method is invoked in situation when program only has serial number and needs the specific InventoryItem, 
	 * especially if it needs to interact with methods in the InventoryItem class.
	 * Returns the InventoryItem with same serial number
	 */
	public InventoryItem lookupItem(int serialNumber) {
		for (InventoryItem product : this.items) {
			if (product.getSerialNumber() == serialNumber) {
				return product;
			}
		}
		return null;
	}
}
