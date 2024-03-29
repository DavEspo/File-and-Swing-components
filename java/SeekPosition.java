import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class SeekPosition2 {
	
	public static void main(String[] args) {
		//This creates a scanner for a user to input
		Scanner Input=new Scanner(System.in);
		//The user has to enter a file name
		System.out.print("Enter a file name >> ");
		String filename=Input.nextLine();
		
		//These make the relative path the user inputed to an absolute path on the computer
		Path inputpath=Paths.get(filename);
		Path fullpath=inputpath.toAbsolutePath();
		
		//The user has to enter a position number
		System.out.print("Enter a position number >> ");
		int PositionNum=Input.nextInt();
		
		//The user has to enter the number of characters to display
		System.out.print("Enter number of characters to display>>");
		int CharToDisplay=Input.nextInt();
		
		try {
			//This abstract class creates methods for inputing from a file
			InputStream input=new BufferedInputStream(Files.newInputStream(fullpath, CREATE));
			
			//This allows to read from an input stream
			BufferedReader reader=new BufferedReader(new InputStreamReader(input));
			
			//This reads the line from the file
			String ReadFromFile=reader.readLine();
			//This converts the String into a character array
			char[] r=ReadFromFile.toCharArray();
			int capacity=CharToDisplay;
			//This allocates a new ByteBuffer where the starting position is 0 and has a certain capacity which is defined in the parameter
			ByteBuffer buffer=ByteBuffer.allocate(capacity*2);
			
			//This contains each given char values in bytes
			for (int i=0;i<capacity;i++) {
				buffer.putChar(r[i+PositionNum]);
			}
			
			//This rewinds the method so that the position is set back to 0
			buffer.rewind();
			
			//This prints out the number of characters the user inputed
			for (int i=0;i<capacity;i++) {
				System.out.print(buffer.getChar());
			}
            System.out.println();
		//This catches any Exceptions and displays the message
		} catch (Exception e) {
			System.out.println("Message: "+e);
		}
	}
}