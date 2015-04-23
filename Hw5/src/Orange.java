/*
CSE 17
Daniel Truong
862607977
Homework #5 DEADLINE: April 13, 2015
Program Description: Generics Inventory
*/
import java.util.Date;
public class Orange extends Fruit{
	//Creates an instance of Orange
	public Orange(String name, int quantity, Date packDate) {
		super(name, quantity, packDate);
	}
	//Returns the a string containing the details of the orange in a specific format
	public String toString() {
		String format = "";
		format += this.getName() + " Orange, " + this.getQuantity() + " fruits, Packaged: " + this.getPackDate();
		return format;
	}
}
