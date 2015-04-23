import java.io.File;
import java.io.PrintWriter;
public class FileDemo {
	public static void main(String[] args) throws Exception{
		if (args.length != 1) {
			System.out.println("Usage: java FileDemo filename");
			System.exit(1);
		}
		
		String filename = args[0];
		File file = new File(filename);
		System.out.println("File:\t\t" + filename);
		System.out.println("Absolute Path:\t" + file.getAbsolutePath());
		System.out.println("Exists?\t\t" + file.exists());
		System.out.println("Can Wead?\t\t" + file.canRead());
		System.out.println("Can Write?\t\t" + file.canWrite());
		System.out.println("Length:\t\t" + file.length());
		
		if (file.exists() == false) {
			
		}
	}
}
