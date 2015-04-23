/*
CSE 17
Daniel Truong
862607977
Program #2 DEADLINE: March 3, 2015
Program Description: Football Box Scores
A football scoring play, this FootballScore class represents a subclass of Score
Practices out ability to use inheritance and aggregation
This class creates a scoring play which represents an instance of score
*/
public class FootballScore extends Score{
	private int quarter;
	private String time;
	private int patPts;
	private String patPlay;
	private String type;
	
	/* When call upon, the FootballScore Constructor will initialize specific instance variables
	 * It also calls on the Score constructor using the "super" keyword, properly depicting the concept of inheritance
	 * Lastly, this constructor will determine how many points the scoring team will receive based on the type of score
	 * Points will then be set using the setPoints method
	 * This method is strictly used if there is a TD because of patPts and patPlay
	 */
	public FootballScore(String team, String type, int quarter, String time, String play, int patPts, String patPlay) {
		super(team, play);
		this.quarter = quarter;
		this.time = time;
		this.patPts = patPts;
		this.patPlay = patPlay;
		this.type = type;
		int points = 0;
		if (type.equals("TD")) {
			points = 6 + this.patPts;			
		}
		else if (type.equals("FG")) {
			points = 3;
		}
		else if (type.equals("SA")) {
			points = 2;
		}
		setPoints(points);
	}
	
	/* This constructor performs the same actions as above
	 * However, it is used if the team does not capitalize on the extra point, given that they did not score a TD. 
	 * Therefore, it does not include patPlay and patPts.
	 */
	public FootballScore(String team, String type, int quarter, String time, String play) {
		super(team, play);
		this.quarter = quarter;
		this.time = time;
		this.patPts = 0;
		this.patPlay = "null";
		this.type = type;
		int points = 0;
		if (type.equals("TD")) {
			points = 6 + this.patPts;
		}
		else if (type.equals("FG")) {
			points = 3;
		}
		else if (type.equals("SA")) {
			points = 2;
		}
		setPoints(points);
	}
	
	//Allows user to get quarter
	public int getQuarter() {
		return quarter;
	}
	
	//returns the time of scoring play
	public String getTime() {
		return time;
	}
	
	//returns the type of point scored
	public String getType() {
		return type;
	}
	
	//Creates a Returns a string of the form "team – play time" or "team – play ( PATplay ) time" depending on the situation
	public String toString() {
		String boxPlay = "";
		if (patPts == 1) {
			boxPlay+=getTeam()+" - "+getPlay()+" ("+this.patPlay+") "+this.time;
			return boxPlay;
		}
		else {
			boxPlay+=getTeam()+" - "+getPlay()+" "+this.time;
			return boxPlay;
		}
	}
}
        