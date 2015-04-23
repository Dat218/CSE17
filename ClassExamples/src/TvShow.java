/**Example for Objects/Class Lecture
   1/26/14 and 1/28/14**/
public class TvShow {
	String name;
	String channel;
	int length;
	
	public TvShow() {
		name = "n/a";
		channel = "n/a";
		length = 0;
	}
	// Construct a new TV show with a given name, channel, and length
	public TvShow(String aName, String aChannel, int aLength) {
		name = aName;
		channel = aChannel;
		length = aLength;
	}
	
	//Return the length of the show in hours
	public double getHours() {
		return length/60.0;
	}
	
	public static void main(String[] args) {
		//TvShow myShow = new tvShow("Breaking Bad", "Amc", 60);
		TvShow myShow = new TvShow();
		myShow.name = "Walking Dead";
		
		System.out.println("Name = " + myShow.name);
		System.out.println("Channel = " + myShow.channel);
		System.out.println("Hour(hrs.) = " + myShow.getHours());
	}
}
