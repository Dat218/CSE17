/*
CSE 17
Daniel Truong
862607977
Program #3 DEADLINE: March 26, 2015
Program Description: Online Store
This class creates an object that represents the specific details of a customers order when
its constructor is invoked. The variables serialNumber will be crucial throughout the program in
order to find the specific product customer wishes to buy. 
*/ 
public class Order {
	private String customer;
	private int serialNumber; 
	private int qty; 
	
	/*Order Constructor
	 *Creates an instance of Order when invoked upon
	 */
	public Order(String customer, int serialNumber, int qty) {
		this.customer = customer;
		this.serialNumber = serialNumber;
		this.qty = qty;
	}
	
	public String getCustomer() {
		return this.customer;
	}
	
	public int getQty() {
		return this.qty;
	}
	
	public int getSerialNumber() {
		return this.serialNumber;
	}	
}
