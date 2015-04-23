/*
CSE 17
Daniel Truong
862607977
Program #4 DEADLINE: April 6, 2015
Program Description: Spell Checker
ArrayUtilList is a class the provides some methods for processing ArrayLists.
It is very generic to allow this program to sort both DictionaryItem AND SuggestedTerm instances with the same method
The binary search is used for the program to find the specific index where a certain term belongs
This class practices the use of ArrayList, generic type, Comparable, and recursion. 
*/
import java.util.ArrayList;
public class ArrayListUtil {
	
	/*
	 * Selection sort allows the program to sort the dictionary and ranked candidates
	 * When it invokes the compareTo method, instead of going to the default library method for compareTo, 
	 * It calls on the SpellChecker or DictionaryItem compareTo method depending on the instance being compared.
	 * This is able to happen b/c these two classes implement the Comparable interface
	 * Comparable variables to allow method to compare the value in the array of any type
	 * Rest is just an ordinary algorithm of the selection sort
	 */
	public static void selectionSort(ArrayList list) {
		//Nested loop for selection sort
		for (int i=0; i<list.size()-1; i++) {
			//Making comparable objects
			Comparable bestOption = (Comparable) list.get(i);
			int indexOfBestOption = i;
			for (int m=i+1; m<list.size(); m++) {
				Comparable tempComparable = (Comparable) list.get(m);
				//Compares the two comparable object. If the next word in for loop comes the current "nextSoundex", then it swaps
				if (tempComparable.compareTo(bestOption) < 0) {
					bestOption = tempComparable;
					indexOfBestOption = m;
				}
			}
			//Swapping of objects 
			if (bestOption != list.get(i)) {
				Comparable temp = (Comparable) list.get(i);
				list.set(i, bestOption);
				list.set(indexOfBestOption, temp);
			}
		}
	}

	/*
	 * BinarySearch is a recursive method that calls on its helper to find index of where a misspelled term in this situation
	 */
	public static int binarySearch(ArrayList list, Comparable key) {
		int min = 0; 
		int max = list.size() - 1;
		return binarySearch(list, key, min, max);
	}
	
	/*
	 * When invoked, binarySearch finds the exact place in the dictionary the typo is supposed to be.
	 * It returns that value to allow the program to find the 10 preceding and subsequent terms
	 * This helper method is recursive and continuously calls on itself until it finds the desired index
	 * or -x-1 if not found. -x-1 will also represent the area where typo should be when negated
	 */
	private static int binarySearch(ArrayList list, Comparable key, int min, int max) {
		if (min > max) {
			return -min-1;
		}
		int mid = (max+min)/2;
		String temp = (String) key;
		temp = temp.toLowerCase();
		String soundex = SpellChecker.soundex(temp);
		DictionaryItem newKey = new DictionaryItem(temp, soundex); 
		DictionaryItem comparedTemp = (DictionaryItem) list.get(mid);
		if (newKey.getTerm().equals(comparedTemp.getTerm())) {
			return 0;
		}
		else if (newKey.compareTo(comparedTemp) < 0) {
			return binarySearch(list, key, min, mid-1);
		}
		else {
			return binarySearch(list, key, mid+1, max);
		}
	}	
}