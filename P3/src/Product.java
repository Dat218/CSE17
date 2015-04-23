/*
CSE 17
Daniel Truong
862607977
Program #3 DEADLINE: March 26, 2015
Program Description: Online Store
The Product is the superclass in this inheritance model and will be necessary when creating every item object at this store
Additionally, it is an abstract class because this is such a vague concept/object that the we invoke the getDescription
method in other classes to get the specific details, which will use the concept of polymorphism. 
*/ 
public abstract class Product {
	double price; 
	int serialNumber;
	
	/* This constructor will initialize the instance variables price and serialNumber 
	 * whenever invoked upon, usually by a subclass.
	 * It is protected so it can be private but still accessible for subclasses.
	 */
	protected Product(double price, int serialNumber) {
		this.price = price;
		this.serialNumber = serialNumber; 
	}
	
	/* By making getDescription an abstract method, we are 
	 * telling the program the the subclasses of Product will include this getDescription 
	 * This is because getting a descriptive for a product would be so abstract since there are so many different products. 
	 */
	public abstract String getDescription();
	
	public double getPrice() {
		return this.price;
	}
	
	public int getSerialNumber() {
		return this.serialNumber;
	}
}
