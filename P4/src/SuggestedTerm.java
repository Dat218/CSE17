/*
CSE 17
Daniel Truong
862607977
Program #4 DEADLINE: April 6, 2015
Program Description: Spell Checker
SuggestedTerm represents the possible substitutes for a misspelled word. 
Because this class implements Comparable, every time compareTo and toString is invoked by a SuggestedTerm instance,
it will run these methods are opposed to the normal compareTo and toString method.
Practices the use of interface and overriding.
*/
public class SuggestedTerm implements Comparable<Object> {
	private String term;
	private int editDistance;
	
	//Creates a SuggestedTerm object that represents a possibly replacement for the type.
	public SuggestedTerm(String term, int editDistance) {
		this.term = term;
		this.editDistance = editDistance;
	}
	
	public String getTerm() {
		return this.term;
	}
	
	public int getEditDistance() {
		return this.editDistance;
	}
	
	public String toString() {
		String format = "";
		return format += this.term + " " + "(" + this.editDistance + ")";
	}
	
	/*
	 * Because this class implements the comparable interface, this compareTo method gets invoked whenever instances of this method is being compared
	 * returns a negative number if this editDistance is less than the editDistance of Object o and vice versa
	 */
	public int compareTo(Object o) {
		return this.editDistance - ((SuggestedTerm) o).getEditDistance();
	}		
}
