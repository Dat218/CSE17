/*
CSE 17
Daniel Truong
862607977
Homework #5 DEADLINE: April 13, 2015
Program Description: Generics Inventory
The parent class of this inheritance series, Item class provides the 
instance variables for all items. Extended by generic types so methods of this class
and its child classes can be used by this program.
*/
public abstract class Item {
	protected String name; 
	protected int quantity;
	
	public Item(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
}
