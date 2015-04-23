import java.util.Scanner;
public class Loops {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner( System.in );
		System.out.print("Enter an int: ");
		int userInput = myScanner.nextInt();
		int superFactorial = 0;
		for (int i=1; i<=userInput; i++) {
			int fact = 1;
			for (int m=i; m>0; m--) {
				fact = fact * m;
			}
			superFactorial += superFactorial + fact;
		}
		System.out.println(superFactorial);
	}
}
