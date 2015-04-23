/*
CSE 17
Daniel Truong
862607977
Program #2 DEADLINE: March 3, 2015
Program Description: Football Box Scores
The descriptions of a specific game
It stores these specific instance variables below because they are shared amongst other football games
Additionally, the Game class keeps track of the home and visitor score.
This practices our ability to use inheritance and aggregation.  
*/
import java.util.Date;
import java.text.SimpleDateFormat;
public class Game {
	private String homeTeam;
	private String visitorTeam;
	private int homeScore;
	private int visitorScore;
	private Date date;
	SimpleDateFormat stdDate = new SimpleDateFormat("MM/dd/yy");
	
	/*Constructor for this Game class
	 * In this program, this constructor gets called on using the super keyword since it is inheriting FootballGame
	 * Initializes instance variables and parses the dateString variable
	 */
	public Game(String homeTeam, String visitorTeam, String dateString) throws Exception {
		this.homeTeam = homeTeam;
		this.visitorTeam = visitorTeam;
		date = stdDate.parse(dateString);
	}
	
	//Returns Home team
	public String getHomeTeam() {
		return homeTeam;
	}
	
	//Returns Visitor Team
	public String getVisitorTeam() {
		return visitorTeam;
	}
	
	//Returns Home Score
	public int getHomeScore() {
		return homeScore;
	}
	
	//Returns Visitor Score
	public int getVisitorScore() {
		return visitorScore;
	}
	
	/* This method will first format the parsed date
	 * Then it will return the String of date in the correct format
	 */
	public String getDateString() {
		return stdDate.format(date);
	}
	
	//Adds points onto the total home score
	public void addToHomeScore(int points) {
		homeScore += points;
	}
	
	//Adds points onto the total visitor score
	public void addToVisitorScore(int points) {
		visitorScore += points;
	}
}
