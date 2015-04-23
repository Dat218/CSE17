/*
CSE 17
Daniel Truong
862607977
Homework #3 DEADLINE: February 18, 2015
Program Description: Document Statistics
	This Document class first ensures that there is ONE command line argument the is only ONE letter
	Next, user is asked to input a line of text which is passed to construct to create an object of the line of text 
	Then constuct splits the line of text and stores each individual word in an array
	Array is then sorted
	Then we create a new array the only contains unique words and a new array that contains the frequency of each unique word
	After all of this, we then use the command line argument and find how many times the letter appears in the line of text
	Everything gets printed in organized format
	PROGRAM IS COMPLETE!!!!
	This program exercises our ability to work with Strings and command line arguments
*/ 
import java.util.Scanner;
public class Document {
	private static Term[] terms;
	
	/*This constructor accepts the inputed user line of Strings.
	 * Then it creates an instance of Document and creates an array of each separate word.
	 */
	Document(String text) {
		String[] tokens = text.split(" ");
		recordTermFreqs(tokens);
	}
	
	/* This method first calls on the method sortString to have it return a sorted array of tokens
	 * Then it finds the number of duplicates, which is used to initialize the distinct method
	 * The distinctTokens array then stores Strings of distinct Tokens by comparing adjacent tokens and seeing if their compareTo() value is 0
	 * If it is zero, it's the same word and will only be stored once.
	 * Once the adjacent word in front of the specified word are not the same, 
	 * loop breaks automatically cause there is no need to search through the whole loop since it's sorted.
	 * tokenFrequency is same thing as distinctTokens
	 * tokenFrequency[0] is the frequency of String distinctTokens[0] and so on
	 */
	private void recordTermFreqs(String[] tokens) {
		sortStrings(tokens);
		int sameStrings = 0; 
		//Find Duplicates
		for (int m=0; m<tokens.length-1; m++) {
			for (int n=m+1; n<tokens.length; n++) {
				if (tokens[m].compareTo(tokens[n]) == 0) {
					sameStrings++;
					break;
				}
				else if (tokens[m].compareTo(tokens[n]) != 0) {
					break;
				}
			}
		}
		//Create an array with only distinct terms, no duplicates
		String[] distinctTokens = new String[tokens.length-sameStrings];
		distinctTokens[0] = tokens[0];
		int index = 0;
		for (int k=1; k<tokens.length; k++) {
			if (tokens[k].compareTo(distinctTokens[index]) != 0) {
				distinctTokens[index+1] = tokens[k];
				index++;
			}
		}
		//Find frequency of distinct terms
		int[] tokenFrequency = new int[distinctTokens.length];
		int tokenCount = 0;
		for (int d=0; d<tokenFrequency.length; d++) {
			tokenCount = 0;
			for (int t=0; t<tokens.length; t++) {
				if (distinctTokens[d].compareTo(tokens[t]) == 0) {
					tokenCount++;
				}
			}
			tokenFrequency[d] = tokenCount;
		}
		//Creates an instance for each term by calling on Term constructor in class Term
		terms = new Term[distinctTokens.length]; 
		for (int j=0; j<distinctTokens.length; j++) {
			terms[j] = new Term(distinctTokens[j], tokenFrequency[j]);
		}	
	}
	
	/*Sorts array through selection sort
	 * Uses compareTo method to determine which word comes first alphabetically 
	 */
	public static String[] sortStrings(String[] tokens) {
		int min = 0;
		for (int i=0; i<tokens.length-1; i++) {
			min = i;
			for (int m=i+1; m<tokens.length; m++) {
				if (tokens[min].compareTo(tokens[m]) < 0) { 
					continue;
				}
				else if (tokens[min].compareTo(tokens[m]) > 0) {
					min = m;
				}
			}
			//Determines the first alphabetically word in sequence before swap process
			String temp = tokens[i];
			tokens[i] = tokens[min];
			tokens[min] = temp;
		}
		return tokens;
	}
	
	/*Obviously, judging by the name of this method, printTermFreqs basically prints out everything we need
	 * First we use maxLength to determine right spacing in between each word 
	 * Then the rest is printed out!
	 */
	public static void printTermFreqs() {
		int maxLength = 0;
		for (int i=0; i<terms.length; i++) {
			if (terms[i].getToken().length() > maxLength) {
				maxLength = terms[i].getToken().length();
			}
		}
		//Needs a minimum for the printed statement to look organized
		if (maxLength < 5) {
			maxLength = 6;
		}
		System.out.print("Term");
		//Proper Spacing
		for (int j=0; j<maxLength-2; j++) {
			System.out.print(" ");
		}
		System.out.println("Frequency");
		System.out.print("------");
		for (int k=0; k<maxLength-4; k++) {
			System.out.print(" ");
		}
		System.out.println("----------");
		for (int l=0; l<terms.length; l++) {
			System.out.print(terms[l].getToken());
			for (int h=0; h<maxLength-(terms[l].getToken().length())+2; h++) {
				System.out.print(" ");
			}
			System.out.println(terms[l].getFrequency());
		}
	}
	
	/*Counts how many times letter appears in the original text 
	 * has each term invoke getLetterCount method from Term to find how many times specific letter 
	 * occurs in the term.
	 * letterAppearances adds all occurrences together and is returned.
	 */
	public static int getLetterCount(char letter) {
		int letterAppearance = 0;
		for (int i=0; i<terms.length; i++) {
			letterAppearance = letterAppearance + terms[i].getLetterCount(letter);
		}
		return letterAppearance;
	}
	
	/* Main method ensures that there is a command line argument
	 * Then it prompts user to input a line of String which is passed to constructor
	 * And finally it invokes the printTermFreqs method to print everything 
	 * Invokes getLetterCount method to find occurrences of specified letter inputed as command line argument
	 * prints out letter appearances
	 */
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		if (args.length == 1) {
			if (args[0].length() == 1) {
				System.out.println("Enter a line of text");
				String userInput = scan.nextLine();
				Document text = new Document(userInput);
				printTermFreqs();
				char letter = args[0].charAt(0);
				int letterCount = getLetterCount(letter);
				System.out.println("The letter "+letter+" appears "+letterCount+" times."); 
			} 
			else {
				System.out.println("Usage: java Document letter");   //Invoked if commandline argument is not a char
			}
		}
		else {
			System.out.println("Usage: java Document letter");    //Invoked if there is not exactly one command line argument
		}
	}
}
