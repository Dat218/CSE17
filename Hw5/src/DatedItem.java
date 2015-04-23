/*
CSE 17
Daniel Truong
862607977
Homework #5 DEADLINE: April 13, 2015
Program Description: Generics Inventory
The DatedItem class is a subclass of the Item class and implements Comparable
in order to use the compareTo method
Additionally, this class stores the packDate instance variable so it will be 
called on more often when program needs the packDate of specific objects.
*/
import java.util.Date;
public abstract class DatedItem extends Item implements Comparable<Object>{
	protected Date packDate;
	
	public DatedItem(String name, int quantity, Date packDate) {
		super(name, quantity);
		this.packDate = packDate;
	}
	
	public Date getPackDate() {
		return this.packDate;
	}
	
	/* 
	 * This method compares the packDate of different items
	 * Returns a negative integer if the item is older
	 * (based on packDate) than the parameter, 0 if they have the same age, and a positive
	 * integer if the item is newer than the parameter.
	 */
	public int compareTo(DatedItem item) {
		if (this.packDate.compareTo(item.getPackDate()) < 0) {
			return -1;
		}
		else if (this.packDate.compareTo(item.getPackDate()) > 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
