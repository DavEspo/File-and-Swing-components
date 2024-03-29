import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.*;

public class ValidateCheckDigits {
	
	public static void main(String[] args) {
		//Creating the paths for the file given and for the file created
		Path File=Paths.get("AcctNumsIn.txt");
		Path NewFile=Paths.get("AcctNumsInAssessed.txt");
		
		try {
			//These abstract classes create methods for inputing from a file and outputting to a file
			InputStream input=new BufferedInputStream(Files.newInputStream(File));
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(NewFile, CREATE));
			
			//These allow to read from an input stream and write to an output stream
			BufferedReader reader=new BufferedReader(new InputStreamReader(input));
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(output));
			
			//This reads the first line on the file
			String ReadFromFile=reader.readLine();
			//This converts the string into an integer
			int GivenNums=Integer.parseInt(ReadFromFile);
			
			//This is the while loop so that every line is read from the file and assessed
			while (ReadFromFile != null) {
				int sum=0;
				//This gives the first five digits of the numbers in the file since the last digit id dropped when dividing by ten
				int FirstFiveDigits=GivenNums/10;
				
				//This is a loop that adds up the individual digits of the number on a line
				while (FirstFiveDigits != 0) {
					sum=sum+FirstFiveDigits%10;
					FirstFiveDigits=FirstFiveDigits/10;
				}
				
				//This writes the numbers that are valid onto another file
				if (sum % 10 == GivenNums%10) {
					writer.write(ReadFromFile, 0, ReadFromFile.length());
					writer.newLine();
				}
				
				//This flushes the stream so that it is clear
				writer.flush();
				
				//This reads the next line in the given file
				ReadFromFile=reader.readLine();
				
				//This converts the String into an integer
				if (ReadFromFile != null) {
					GivenNums=Integer.parseInt(ReadFromFile);
				}
			}
			//This closes the streams after the while loop is done
			writer.close();
			reader.close();
		//This catches any Exceptions and displays the message
		} catch(IOException e) {
			System.out.println("Message: "+e);
		}
		
	}
	
}