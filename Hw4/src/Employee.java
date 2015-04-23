/*
CSE 17
Daniel Truong
862607977
Homework #4 DEADLINE: March 17, 2015
Program: CSE Department Personnel
Employee is the superclass of faculty
Aside from constructing an instance for every employee object with its constructor, 
Employee also checks to see if there are duplicates when the equalTo method is invoked.
This class practices the use of inheritance and overriding. 
*/
public class Employee {
	protected String name;
	protected String title;
	protected String email;
	
	/* Constructor that sets arguments equal to respective instance variables
	 * Demonstrates inheritance
	 * Creates an instance of Employee
	 */
	public Employee(String name, String title, String email) {
		this.name = name;
		this.title = title;
		this.email = email;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	//Creates string in correct format to output when invoked
	//Overrides the toString method in the Faculty class
	public String toString() {
		String employeeInfo = "";
		employeeInfo += this.name + " (" + this.email + "), Staff, " + this.title;
		return employeeInfo;
	}
	
	/* This method first ensures that the argument is an instance of employee
	 * Then it checks whether or not the local object, or employee, is a dup by comparing e-mails.
	 * If dup is found, true is returned and vice versa.
	 */
	public boolean equals(Object o) {
		if (o instanceof Employee) {
			Employee temp = ((Employee) o);
			if(temp.getEmail().equals(this.email)) {
				return true;
			}
			else {
				return false;
			}
		}
		return true;
	}
}
