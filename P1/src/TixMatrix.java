/*
CSE 17
Daniel Truong
862607977
Program #1 DEADLINE: February 12, 2015
Program Description: TixMatrix
In this class, we are practicing our ability to have this TixMatrix
program interact with the Seats class in specific situations, data encapsulation
object oriented thinking, and using classes, objects and instances. 
*/ 
import java.util.Scanner;
public class TixMatrix {
	private static Seat[] seats;
	private static int numSold = 0;
	//This constructor creates the show, which represents an instance of TixMatrix
	TixMatrix(int[] section, int seatRow, int number) {
		seats = new Seat[section.length*seatRow*number];
		int count = 0; //Gives each seat its own index 
		char row = ' ';
		//Loop goes through each seat in a row 
		//As it goes through all the seats in a section before moving on to new section
		for (int i=1; i<section.length+1; i++) {
			for (int m=1; m<seatRow+1; m++) {	
				for (int k=1; k<number+1; k++) {
					row = (char)(96+m);
					seats[count] = new Seat(i+100, row, k); //This will create each separate seat
					count++;
				}
			}
		}
	}
	//Nothing special, used as default. Not invoked at all.
	//But calls on constructor above to avoid redundant coding
	//Created instance defaultShow just to create it
	TixMatrix() {
		int[] section = {101, 102, 103, 104};
		int row = 5;
		int number = 10; 
		TixMatrix defaultShow = new TixMatrix(section, row, number); 
	}
	
	/*This sellSeat method first invokes the isSold method to check whether or not the seat has been sold or not
	 * If the seat is already sold, it returns true to the sellSeat method below.
	 * If seat is not sold, it will first set this seats value to true for future reference 
	 * and then return true to tell user about the successful transaction. 
	 */
	private boolean sellSeat(Seat seats) {
		if (seats.isSold() == false) {
			seats.sellSeat();
			numSold++;
			return false;
		}
		else {
			return true;
		}
	}
	
	/*Method that finds the correct index in which the seat requested by user is an actually seat
	 * It goes through a linear search to find correct index by comparing the section row and seat number.
	 * Then it calls another sellSeat method above for the rest of the steps. 
	 * Then it returns FALSE if seat is BEING sold or TRUE if the seat is ALREADY sold.
	 */
	private boolean sellSeat(int section, char row, int number) {
		boolean sellingSeat = true;
		for (int i=0; i<seats.length; i++) {
			if (seats[i].getSection() == section && seats[i].getRow() == row && seats[i].getNumber() == number) {   //Determines if user requests for a seat within limits
				sellingSeat = sellSeat(seats[i]); 
			}
		}
		return sellingSeat; 
	}
	/* getBestAdjacentSeat finds a list of adjacent unsold seats. requestedNum represents the number of seats requested by user and returns an array with length equal to requestedNum
	 * arrayOfSeatValues array represents the indexes where one can find desired number of adjacent seats
	 * adjacentSeatCount used to keep track of number of current adjacentSeats
	 */
	private int[] getBestAdjacentSeat(int requestedNum) {
		int[] arrayOfSeatValues = new int[requestedNum];
		int adjacentSeatCount = 0; 
		int maxNumber = seats[seats.length-1].getNumber();
		for (int m=0; m<requestedNum; m++) {
			arrayOfSeatValues[m] = 0; 
		}
		//This loop allows program to pass through every seat in show when finding adjacent seats
		for (int i=0; i<seats.length-1; i++) {
			//ensure seats are not sold. If it is already sold, everything gets reset when finding new number of desired adjacent seats
			if (seats[i].isSold() == false) {
				/*Purpose of this is because if statement is if we reach the beginning of a new row, there is no point in continuing the adjacent seat sequence
				*  So we we set the first value of array equal to the first row, set adjacentSeatCount to 1 for the next seat, and restart process
				*/
				if (i%maxNumber == 0) { 
					arrayOfSeatValues[0] = i;
					adjacentSeatCount = 1;
				}	
				//For rest of the seats in row
				else if (i%maxNumber != 0) {
					/*I included this if statement because if there has been a seat set in first value of array, this seat is 
					* automatically set there so we can compare this seat with next seat to check for adjacency.
					*/
					if (adjacentSeatCount == 0) {
						arrayOfSeatValues[adjacentSeatCount] = i;
						adjacentSeatCount++;
					}
					//Checks seat for adjacency. if it is adjacent, this stores seat index in array.
					else {
						if(seats[arrayOfSeatValues[adjacentSeatCount-1]].isAdjacentTo(seats[i]) == true) {
							arrayOfSeatValues[adjacentSeatCount] = i;
							adjacentSeatCount++;
						}
						//Resets array if seats are not adjacent
						else {
							adjacentSeatCount = 0;
							for (int j=0; i<requestedNum; i++) {
								arrayOfSeatValues[j] = 0; 
							}
						}
					}
				}
			}
			//This is where everything in this method resets if a sold seat is discovered, which would ruin adjacent seat pattern.
			else {
				adjacentSeatCount = 0;
				for (int j=0; i<requestedNum; i++) {
					arrayOfSeatValues[j] = 0; 
				}
			} 
			//If an array of desired adjacent seats is already found, it is automatically returned
			if (arrayOfSeatValues[requestedNum-1] > 0) {
				return arrayOfSeatValues;
			}
		}
		return arrayOfSeatValues;
	}
	//Used if user enters 3, returns total number of seats sold
	private static int getNumSeats() {
		return seats.length;
	}
	//Used if user enters 3, returns total number of seats sold
	private static int getNumSold() {
		return numSold;
	}
	/*Used if user enters 3. Prints out all of the unsold seats.
	 * Finds unsold seat by calling isSold Method
	 * Prints out seat by using getSeatId Method
	 */
	private static void printAllUnsoldSeats() {
		for (int i=0; i<seats.length; i++) {
			if (seats[i].isSold() == false) {
				System.out.println(seats[i].getSeatId());
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] totalSection = {101, 102};
		TixMatrix show;     
		show = new TixMatrix(totalSection, 4, 5);  //Constructs our show
		int userInput = 0;
		do {
			userInput = 0;
			System.out.println("Enter a numeric choice: 1) best available, 2) specific seat, 3) quit: ");	
				userInput = scan.nextInt();
				if (userInput == 1) {
					System.out.println("How many adjacent seats? ");
					int userDesiredSeats = scan.nextInt();
					int[] adjacentSeats = show.getBestAdjacentSeat(userDesiredSeats);  //Sets an array that will store the value of the seats indices which are adjacent to each other
					for (int i=0; i<adjacentSeats.length; i++) {
						show.sellSeat(seats[adjacentSeats[i]]);  //Sells each seat separately.   
						if (i != adjacentSeats.length-1) {
							System.out.print(seats[adjacentSeats[i]].getSeatId()+", ");  //Prints out each of the seats that were just sold
						}
						else {
							System.out.println(seats[adjacentSeats[i]].getSeatId());
						}
					}
				}
				else if (userInput == 2) {
					System.out.println("Enter section, row, and number, separated by spaces: ");
					int section = scan.nextInt();
					String desiredRow = scan.next();
					char row = desiredRow.charAt(0);  //converts the stored String input above into a char
					int number = scan.nextInt();
					//Calling method that will check if desired seat is available and sell if it is available.
					boolean sellingSeat = show.sellSeat(section, row, number); 
					if (sellingSeat == false) {
						System.out.println("Seat sold!");      
					}
					else {
						System.out.println("Sorry Seat has been sold already"); //Printed if specific seat is unavailable
					}
				}
				else {
					System.out.println("Sold "+getNumSold()+" of "+getNumSeats()+ " ("+((double)getNumSold()/getNumSeats())*100+" percent) seats");
					System.out.println("All unsold Seats");
					printAllUnsoldSeats();  
				}
		}while (userInput == 1 || userInput == 2);    
	}
}

