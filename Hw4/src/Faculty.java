/*
CSE 17
Daniel Truong
862607977
Homework #4 DEADLINE: March 17, 2015
Program: CSE Department Personnel
Faculty class is a subclass of Employee
Used if there is research by the employee name in the file
This class practices the use of overriding and inheritance
*/
public class Faculty extends Employee{
	private String research;

	public Faculty(String name, String title, String email, String research) {
		super(name, title, email); //Calling on superclass constructor
		this.research = research;
	}
	
	public String getResearch() {
		return research;
	}
	
	//Creates string in correct format to output when invoked
	//Overrides the toString method in the Employee class
	public String toString() {
		String facultyInfo = "";
		facultyInfo += this.name + " (" + this.email + "),  " + this.title + "\n" + "\t" + this.research;
		return facultyInfo;
	}
}
