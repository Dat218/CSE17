/*
CSE 17
Daniel Truong
862607977
Program #3 DEADLINE: March 26, 2015
Program Description: Online Store
The Book class is a subclass to Product, practicing the concept of inheritance.
*/ 
public class Book extends Product{
	private String title;
	private String author;
	
	/*Book constructor class that creates an instance of book.
	 *Because this class extends, the code must use the super keyword to call the 
	 *Product constructor to initialize price and serialNumber,
	 *since these instance variables are shared amongst all products.
	 */
	public Book(int serialNumber, String title, String author, double price) {
		super(price, serialNumber);
		this.title = title;
		this.author = author;
	}
	
	//Returns a description of the specific book when invoked in a specific format
	public String getDescription() {
		String description = "";
		return description += this.title + " by " + this.author;
		
	}
}
