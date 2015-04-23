/*
CSE 17
Daniel Truong
86207977
Homework #3 DEADLINE: February 18, 2015
Program Description: Document Statistics
	Our objective for this program is to create a class that interacts with the Document
	Class when invoked and create many instances. 
	This class represents a unique token in the document and stores the token's frequency.
	It also determines how many times a word appears in a word. 
	Practices the use of data encapsulation and abstraction
*/ 
public class Term {
	private String token;
	private int frequency;
	
	/*Constructor creates an instance for each distinct term
	 * Stores the term and the number of times it appears
	 * Used for reference in methods below.
	 */
	Term(String token, int frequency) {
		this.token = token;
		this.frequency = frequency;
	}
	
	//Returns the token of specific instance
	public String getToken() {
		return this.token;
	}
	
	//returns frequency of specific instance
	public int getFrequency() {
		return this.frequency;
	}
	
	/* This method finds the amount of times the letter appears in the specific term
	 * Then number of times the loop runs depends on the length of the term
	 * This allows loop to compare the specified letter with every letter in the term
	 * After we find how many times the letter appears in the term, it is multiplied by the frequency 
	 * to find total letter appearance of the letter.
	 */
	public int getLetterCount(char letter) {
		int letterAppearance = 0;
		for (int j=0; j<this.token.length(); j++) {
			if (letter == this.token.charAt(j)) {
				letterAppearance++;
			}
		}
		letterAppearance = letterAppearance * this.frequency;
		return letterAppearance;
	}
}
