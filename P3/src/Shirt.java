/*
CSE 17
Daniel Truong
862607977
Program #3 DEADLINE: March 26, 2015
Program Description: Online Store
The Shirt class is a subclass to Product, practicing the concept of inheritance.
*/ 
public class Shirt extends Product{
	private String type; 
	private String size;
	private String color;
	
	/*Shirt constructor class that creates an instance of shirt.
	 *Because this class extends Product, the code must use the super keyword to call the 
	 *Product constructor to initialize price and serialNumber,
	 *since these instance variables are shared amongst all products.
	 */
	public Shirt(int serialNumber, String type, String size, String color, double price) {
		super(price, serialNumber);
		this.type = type;
		this.size = size;
		this.color = color; 
	}
	
	//Returns a description of the specific book when invoked in a specific format
	public String getDescription() {
		String description = "";
		return description += this.color + " " + this.type + " - " + this.size; 
	}
}
