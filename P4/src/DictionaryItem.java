/*
CSE 17
Daniel Truong
862607977
Program #4 DEADLINE: April 6, 2015
Program Description: Spell Checker
DictionaryItem represents every word/instance in the dictionary.
Because this class implements Comparable, every time compareTo, equals, and toString is invoked by a DictionaryItem instance,
it will run these methods are opposed to the default method.
This class practices the use of interface and overriding. 
*/
public class DictionaryItem implements Comparable<Object> {
	private String term;
	private String soundex;
	
	//Creates an instance of DictionaryItem which represents a term in the dictionary
	public DictionaryItem(String term, String soundex) {
		this.term = term;
		this.soundex = soundex;
	}
	
	public String getTerm() {
		return this.term;
	}
	
	public String getSoundex() {
		return this.soundex;
	}
	
	/*
	 * Because this class implements the comparable interface, equals() gets invoked whenever instances of this method is being compared
	 * when checking to see if both this term and the term of passed object is equal.
	 */
	public boolean equals(Object o) {
		if (((DictionaryItem) o).getTerm().equals(this.term)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	 * Because this class implements the comparable interface, this compareTo method gets invoked whenever instances of this method is being compared
	 * Returns negative number this soundex comes before the soundex of Object o and vive versa.
	 * If soundexs are equal, compareTo() than compares the terms and returns the value of that
	 */
	public int compareTo(Object o) {
		DictionaryItem temp = (DictionaryItem) o;
		//If soundex of two compared objects are same, it sorts by term
		if (this.soundex.compareTo(temp.getSoundex()) == 0) {
			return (this.term.compareTo(temp.getTerm()));
		}
		else {
			return (this.soundex.compareTo(temp.getSoundex()));
		}
	}
	
	public String toString() {
		String format = "";
		return format += this.soundex + ":" + this.term;
	}
}
