/*
CSE 17
Daniel Truong
862607977
Homework #5 DEADLINE: April 13, 2015
Program Description: Generics Inventory
This class relies heavily on the use of generics in order to organize the class, 
provide the specific details when invoke and  can be parameterized with the class Item or any subclass of it.
*/
import java.util.Date;
import java.util.ArrayList;
public class Inventory<T extends Item> {
	private  ArrayList<T> inventory;
	
	/*
	 * No arg constructor that initializes the ArrayList
	 * It will be paramatized with the concrete type.
	 */
	public Inventory() {
		this.inventory = new ArrayList<T>(); 
	}
	
	/*
	 * Adds the item to its respective ArrayList
	 * For example; this class will add a Milk object to an ArrayList<Milk> array
	 */
	public void addItem(T item) {
		this.inventory.add(item);
	}
	
	//Returns Item of specific index.
	public T getItem(int index) {
		try {
			return inventory.get(index);
		} catch (NullPointerException ex){
			System.out.println("No items in the array. Can't return oldest item");
		} catch (IndexOutOfBoundsException ex){
			System.out.println("No items in the array. Can't return oldest item");
		}
		return null;
	}		
	
	//Returns quantity of specific 
	public int getQuantity(int index) {
			return ((Item) inventory.get(index)).getQuantity();
	}
	
	/*
	 * Prints the inventory of a specific ArrayList of objects
	 * Uses the generic type T to specify the exact type of item 
	 * program will be printing the inventory of.
	 */
	public static <T extends Item> void printInventory(Inventory<T> item) {
		for (int i=0; i<item.inventory.size(); i++) {
			System.out.println(item.inventory.get(i).toString());
		}
	}
	
	/*
	 * Compares the packDate of items in the inventory using the compareTo method in the DatedItem class
	 * Generic type T allows the program to specify which kind of object to look through and accept any type of object
	 * Returns the oldest item
	 */
	public static <T extends DatedItem> T getOldestItemFromInventory(Inventory<T> stock) {
		try {
			T oldestItem = stock.inventory.get(0);
			Date oldestItemDate = stock.inventory.get(0).getPackDate();
			for (T item : stock.inventory) {
				if (item.getPackDate().compareTo(oldestItemDate) < 0) {
					oldestItem = item;
					oldestItemDate = item.getPackDate();
				}
			}
			return oldestItem;
		} catch (NullPointerException ex){
			System.out.println("No items in the array. Can't return oldest item");
		} catch (IndexOutOfBoundsException ex){
			System.out.println("No items in the array. Can't return oldest item");
		}
		return null;
	}
	
	/*
	 * First initializes date variable to the current date
	 * Then creates a new Orange instance and adds it to its respective inventory.
	 */
	public static void addOrangesToInventory(Inventory<Fruit> stockFruit, String fruit, int quantity) {
		Date date = new Date();
		stockFruit.addItem(new Orange(fruit, quantity, date));
	}
}                                                                                                                                                              
