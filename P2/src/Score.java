/*
CSE 17
Daniel Truong
862607977
Program #2 DEADLINE: March 3, 2015
Program Description: Football Box Scores
Represents a scoring play
This practices inheritance because the instance variables team, play, and points are 
always being inherited by its subclasses.
In this class, team, play, and points are assigned and initialized.
Then it will return those specific variables when invoked. 
*/
public class Score {
	private String team;
	private String play;
	private int points;
	
	//Constructor class initializes specific instance variables
	public Score(String team, String play, int points) {
		this.team = team;
		this.play = play;
		this.points = points;
	}
	
	//Overloading constructor class that initializes passed variables and sets points to 1 as default
	public Score(String team, String play) {
		this.team = team;
		this.play = play;
		setPoints(1);
	}
	
	//returns the team that scored when called
	public String getTeam() {
		return this.team;
	}
	
	//return the scoring play in its entirety
	public String getPlay() {
		return this.play;
	}
	
	//Returns the amount of points from this scoring play/instance
	public int getPoints() {
		return this.points;
	}
	
	//Sets the amount of points team scored. Stored in specific instance
	public void setPoints(int points) {
		this.points = points;
	}
}
