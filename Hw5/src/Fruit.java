/*
CSE 17
Daniel Truong
862607977
Homework #5 DEADLINE: April 13, 2015
Program Description: Generics Inventory
*/
import java.util.Date;
//Abstract subclass of the DatedItem Class and bases the arguments via super
public abstract class Fruit extends DatedItem{
	public Fruit(String name, int quantity, Date packDate) {
		super(name, quantity, packDate);
	}
}
