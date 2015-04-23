/*
CSE 17
Daniel Truong
862607977
Homework #4 DEADLINE: March 17, 2015
Program: CSE Department Personnel
The Department class is an instance of a specific department and contains all the staff and faculty members
This class reads all the individuals from a file and then calls on the Employee and Faculty constructor to create 
an object for each individual and store it in the department using the arraylist.
Then the class will print out all the faculty in a specific format and all of their personal information.
It will ignore all duplicates.
This class demonstrates the use of overriding (when calling toString), creating/reading files, arraylists, and exception handling.
*/
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Department {
	private ArrayList<Employee> people;
	
	//Automatically initializes people to be empty
	public Department() {
		people = new ArrayList<Employee>();
	}
	
	/* The method readPeopleFromFile will first declare and initialize the file using the File import and
	 * read the file using the Scanner import. Then it sets the specific type of word equal to its respective
	 * variable. Then an instance of employee is created (through either the employee or faculty constructor).
	 * After it is created, the method will check whether or not there is a duplicate by comparing current employee
	 * email with the email address of every other employee already added in the people arraylist.
	 * If it is not the same, count increments by one. If count equals the length of the current arraylist,
	 * that means that there is no duplicates. It will add the current employee to arraylist.
	 * Method continues process until whole file has been read. 
	 */
	public void readPeopleFromFile(String filename) {
		File file = new File(filename);
		try { //Try/catch will check for FileNotFoundException
			Scanner fileContent = new Scanner(file);
			fileContent.useDelimiter("\\t|[\\n\\r\\f]+");
			while (fileContent.hasNext()) {
				String type = fileContent.next(); 
				String name = fileContent.next();
				String title = fileContent.next();
				String email = fileContent.next();
				//Used if type is staff
				if (type.equals("S")) {
					Employee employee = new Employee(name, title, email);
					int count = 0;
					//Code should determine if there is duplicate email.
					outerloop:
					for (Employee individual : people) {	
						if (employee.equals(individual) == false) {
							count++; //Used to keep track of number of staff who do not share same email as current employee
						}
						//If duplicate is found
						else { 
							System.out.println("Skipping duplicate for "+email);
							break outerloop; //Break outerloop used for efficiency to prevent program from searching rest of arraylist if dup is found. 
						}
					}
					if (count == people.size()) {
						people.add(employee);
					}
				}
				//Repeats same process as above
				else if (type.equals("F")) {
					String research = fileContent.next();
					Employee employee = new Faculty(name, title, email, research); 
					int count = 0;
					outerloop:
					for (Employee individual : people) {	
						if (employee.equals(individual) == false) {
							count++;
						}
						else {
							System.out.println("Skipping duplicate for "+email);
							break outerloop;
						}
					}
					if (count == people.size()) {
						people.add(employee);
					}
				}
				else {
					System.out.printf("Skipping %s Wrong type: %s \n", name, type );
				}
			}
			System.out.println("\n" + "CSE People: (" + people.size() + " total)");
		} catch (FileNotFoundException ex) {
			System.out.println("ERROR: Couldn't read from file file-name”");
		}
	}
	
	/* Prints the CSE professors and their personal information by calling the toString methods
	 * toString method is exemplifying overriding. 
	 */
	public void printPeople() {
		for (Employee employee : people) {
			System.out.println(employee.toString());
		}
	}
	
	/* Main method checks to make sure that there is only one command line argument
	 * Then it creates a Department object 
	 * Finally, it will call readPeopleFromFile and printPeople method to do the rest of the dirty work
	 */
	public static void main (String[] args) {
		if (args.length == 1) {
			System.out.println("Reading people from file...");
			String filename = args[0];
			Department department = new Department();
			department.readPeopleFromFile(filename);
			department.printSongRow();
		}
		else {
			System.out.println("Usage: java Department filename");
		}
	}
}
