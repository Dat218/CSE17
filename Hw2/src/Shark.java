/*
 * CSE 17
 * Daniel Truong
 * 862607977
 * Homework #2
 * DEADLINE: February 1, 2015
 * Program Description: Shark Tagging
 * In this program, we will be incorporating 
 * the use of class, objects, instances, and methods. 
 * Our objective is to 
 * print out a series of sharks and specific features 
 * about each of them. 
 */
public class Shark {
	//Creating data fields
	int id; 
	String name;
	String species;
	char sex;
	int weight;
	static int nextId = 1;
	
	/*In this constructor, we are creating instances for each four sharks
	 * This constructor starts off by accepting 4 arguments
	 * Then it assigns the arguments to its respective characteristic.
	 */
	Shark(String sharkName, String sharkSpecies, char sharkSex, int sharkWeight) {
		id = nextId;
		name = sharkName;
		species = sharkSpecies;
		sex = sharkSex;
		weight = sharkWeight;
		nextId++;
	}
	
	/*This instance multiplies an invoked shark's weight by 1.10
	 * to increase its weight by 10%
	 */
	public void gainWeight () {
		weight*=1.10; 
	}
	
	//This instance is used to print the info for each shark 
	public void printShark() {
		System.out.println("ID: "+id+", "+name+", "+species+" ("+sex+"), "+weight+" lbs.");
	}
	
	/*The first step of this static method is to find the largest shark
	 * Then it returns the weight of the largest shark
	 */
	public static Shark getLargestShark(Shark[] orderedSharks) {
		Shark largestShark = orderedSharks[0];
		for (int i=0; i<4; i++) {
			if (orderedSharks[i].weight > largestShark.weight) {
				largestShark = orderedSharks[i];
			}
		}
		return largestShark;
	}
	
	public static void main(String[] args) {
		/*Information for each shark that passes 
		 *through the constructor so each shark will have its own instance*/ 
		Shark shark1 = new Shark("Tim", "Hammerhead", 'M', 620);
		Shark shark2 = new Shark("Edge", "Lemmon", 'M', 175);
		Shark shark3 = new Shark("Sheila", "Great White", 'F', 2200);
		Shark shark4 = new Shark("Buster", "Bull", 'M', 205);
		
		Shark orderedSharks[] = {shark1, shark2, shark3, shark4};
		
		for (int i=0; i<orderedSharks.length; i++) {
			orderedSharks[i].printShark();
		}
		
		System.out.println("");
		System.out.println("The biggest shark is:");
		Shark largestShark = getLargestShark(orderedSharks); //Finding the largest shark first
		largestShark.printShark(); //Printing info of largest shark
		System.out.println("");
		
		System.out.println("Changing Buster's weight...");
		shark4.gainWeight();  //Adding weight to Buster
		shark4.printShark();  //Outputting Buster's info
		System.out.println("");
		
		System.out.println("Next available Id: "+nextId); 
	}
}

