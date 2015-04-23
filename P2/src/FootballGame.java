/*
CSE 17
Daniel Truong
862607977
Program #2 DEADLINE: March 3, 2015
Program Description: Football Box Scores
This class is a subclass of Game and is a descriptions of a game of football.
First, FootballGame will read the file and store its values in its respective variable
Then it will call on the FootballScore class to create n scores for the array
It will use all the variables and array of FootballScores to create a FootballGame instance of Game
Finally, this class will print out all of the game's information in a box score format
Practices our ability to use inheritance, command line arguments, aggregation, and files. 
*/
import java.io.File;
import java.util.Scanner;
public class FootballGame extends Game {
	private String homeShort;
	private String visitorShort;
	private static FootballScore[] scores;
	
	/* Constructor for the class
	 * Calls super class to initialize inherited instance variables
	 * Calls on sumScores to add total scores for each team
	 */
	public FootballGame(String homeTeam, String homeShort, String visitorTeam, String visitorShort, String dateString, FootballScore[] scores) throws Exception {
		super(homeTeam, visitorTeam, dateString);
		this.homeShort = homeShort;
		this.visitorShort = visitorShort;
		sumScores();
	}
	
	/* SumScores first determines whether the home or visiting team scored
	 * Then it adds points to total of respective team
	 */
	private void sumScores() {
		for (int i=0; i<scores.length; i++) {
			if (scores[i].getTeam().equals(homeShort)) {
				addToHomeScore(scores[i].getPoints());
			}
			else if (scores[i].getTeam().equals(visitorShort)) {
				addToVisitorScore(scores[i].getPoints());
			}
		}
	}
	
	/* Array of int four indices long which stores total points for each quarter
	 * Method checks each scoring play to see if the home team scored first
	 * Then it determines if the point occurred in i(integer used for loop) quarter
	 * Adds on to the value of the loop for the quarter in which point was scored on
	 */
	public int[] getHomeScoreByQuarter() {
		int[] homeScoreByQuarter = new int[4];
		for (int set=0; set<4; set++) {
			homeScoreByQuarter[set] = 0;
		}
		for (int i=0; i<4; i++) {
			for  (int m=0; m<scores.length; m++) {
				if (scores[m].getQuarter() == i+1 && scores[m].getTeam().equals(homeShort)) {
						homeScoreByQuarter[i] += scores[m].getPoints();
				}
			}
		}
		return homeScoreByQuarter;
	}
	
	/* Includes same algorithm as the method above
	 * Except it calculates points per quarter for visiting team
	 */
	public int[] getVisitorScoreByQuarter() {
		int[] visitorScoreByQuarter = new int[4];
		for (int set=0; set<4; set++) {
			visitorScoreByQuarter[set] = 0;
		}
		for (int i=0; i<4; i++) {
			for  (int m=0; m<scores.length; m++) {
				if (scores[m].getQuarter() == i+1 && scores[m].getTeam().equals(visitorShort)) {
					visitorScoreByQuarter[i] += scores[m].getPoints();
				}
			}
		}
		return visitorScoreByQuarter;
	}
	
	//Prints out the whole box score
	public void printBoxScore() {
		System.out.print(getVisitorTeam()+" at "+getHomeTeam()+ " on "+getDateString()+": ");
		//Conditional statement below ensures that program outputs the winning team score first and then the losing team score (i.e. 24-17)
		if (getVisitorScore() > getHomeScore()) {
			System.out.println(getVisitorScore()+"-"+getHomeScore());
		}
		else {
			System.out.println(getHomeScore()+"-"+getVisitorScore());
		}
		int length = 21;  //Random length chosen for number of spaces before scoreByQuarter for each team would be printed. Looks good. 
		String homeOutput = getHomeTeam();
		String visitorOutput = getVisitorTeam();
		int[] homeQuarterStats = getHomeScoreByQuarter();
		int[] visitorQuarterStats = getVisitorScoreByQuarter();
		for (int i=0; i<length-getHomeTeam().length(); i++) {
			homeOutput += " ";
		}
		for (int i=0; i<length-getVisitorTeam().length(); i++) {
			visitorOutput += " ";
		}
		for (int i=0; i<4; i++) {
			homeOutput += homeQuarterStats[i] + "  ";
			//Conditional statement used for proper positioning for score. i.e. Getting the 0 below the 4 in 14 for the first quarter
			if (homeQuarterStats[i] > 9 && visitorQuarterStats[i] < 10) {
				visitorOutput += " " + visitorQuarterStats[i] + " ";
			}
			else {
				visitorOutput += visitorQuarterStats[i] + "  ";
			}
		}
		homeOutput += "-  " + getHomeScore();
		visitorOutput += "-  " + getVisitorScore();
		System.out.println(homeOutput);
		System.out.println(visitorOutput);
		int scoreCount = 0;
		for (int q=1; q<5; q++) {
			switch(q) {
			case 1: System.out.println("First Quarter"); break;
			case 2: System.out.println("Second Quarter"); break;
			case 3: System.out.println("Third Quarter"); break;
			case 4: System.out.println("Fourth Quarter"); break;
			}
			for (int s=0; s<scores.length; s++) {
				if (scores[s].getQuarter() == q) {
					System.out.println(scores[s].toString());
					scoreCount++;
				}
			}
			if (scoreCount == 0) {
				System.out.println("No Score");
			}
		}
	}
	
	/* This readGameFromFile method first reads the content of the file using the Scanner.
	 * Then it assigns values to specific variables that describe what the value represents in a football game.
	 * As it records every variable for the each scoring play, a FootballScore constructor is called 
	 * to create an instance for each of the specific scoring plays.
	 * Each scoring play is stored in a FootballScore array called scores.
	 * Then all every necessary variable gets passed to the FootballGame constructor to create an instance. 
	 * of FootballGame.
	 * the game variable represents this instance and is returned
	 */
	public static FootballGame readGameFromFile(String filename) throws Exception {
		File file = new File(filename);
		Scanner fileContent = new Scanner(file);
		fileContent.useDelimiter("\\t|[\\n\\r\\f]+");
		String dateString = fileContent.next();
		String homeTeam = fileContent.next();
		String homeShort = fileContent.next();
		String visitorTeam = fileContent.next(); 
		String visitorShort = fileContent.next();
		int numPlays = fileContent.nextInt();
		scores = new FootballScore[numPlays];
		/*numPlays is crucial because it allows us to initialize the scores array
		 * and gives the program a specific number of lines that it has 
		 * to obtain information from for each scoring play 
		 */
		for (int i=0; i<numPlays; i++) {
			int quarter = fileContent.nextInt();
			String time = fileContent.next();
			String team = fileContent.next();
			String type = fileContent.next();
			String play = fileContent.next();
			/*The conditional statement before determines if there is a successful extra point conversion following a TD
			 * If there is an integer after the play, that means there is no patPts because the integer would 
			 * represent the quarter of the next scoring play.
			 * Therefore, if there is no extra point (patPts or patPlay), then we need to call on a different constructor 
			 * like in the else statement.
			 */
			if (!fileContent.hasNextInt() && fileContent.hasNext()) {
				String patPlay = fileContent.next();
				int patPts = fileContent.nextInt();
				scores[i] = new FootballScore(team, type, quarter, time, play, patPts, patPlay);
			}
			else {
				scores[i] = new FootballScore(team, type, quarter, time, play);
			}
		}
		FootballGame game = new FootballGame(homeTeam, homeShort, visitorTeam, visitorShort, dateString, scores);
		return game;
	}
	
	//main method that stores the file, calls on readGameFromFile to store specific variables and create instances, 
	//and finally calls on the printBoxScore method to obviously print everything out. 
	public static void main(String[] args) throws Exception {
		String filename = args[0];
		FootballGame game = readGameFromFile(filename);
		game.printBoxScore();
	}
}