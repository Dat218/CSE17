/*
CSE 17
Daniel Truong
862607977
Program #1 DEADLINE: February 12, 2015
Program Description: TixMatrix
This class interacts with the TixMatrix class when invoked
Returns desired information and makes the overall program 
more organized and effective
*/ 
public class Seat {
	private int section; 
	private char row;
	private int number;
	private boolean sold = false; 
	//constructing a seat. represents instance of show. This statements to ensure that variables assiciation with seat class. 
	Seat(int section, char row, int number) {
		this.section = section;
		this.row = row;
		this.number = number;
		this.sold = false;
	}
	//For returning seat user bought
	public int getSection() {
		return this.section;
	}
	//For returning seat user bought
	public char getRow() {
		return this.row;
	}
	//For returning seat user bought
	public int getNumber() {
		return this.number;
	}
	//For program to check if seat is already sold
	public boolean isSold() {
		return sold;
	}
	//Sets sold for invoked seat to true, ensures that seat won't be sold twice
	public void sellSeat() {
		this.sold = true;
	}
	//For returning seat user bought
	public String getSeatId() {
		String SeatId = "Sect. "+this.section+" "+this.row+this.number;
		return SeatId;
	}
	/* This method checks to check to see if the a seat is adjacent to the seat that is being invoked upon 
	 * Returns true if seats are adjacent and false if it isn't.
	 */
	public boolean isAdjacentTo(Seat seats) {
		if (this.section == seats.getSection() && this.row == seats.getRow() && this.number == seats.getNumber()-1) {
			return true; 
		}
		else {
			return false;
		}
	}
}