import java.io.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		/* Variable Declaration */
		ArrayList<String> names = new ArrayList<>();
		
		/* Input */
		names.add("Bob");
		names.add("Mary");
		names.add("Nick");
		names.add("Helen");
		
		File f = new File("names.txt"); // Creating the File 
		
		// We use the Constructor to set its name (names.txt)
		
		try {
			FileWriter writer = new FileWriter(f); // Adding our File to a FileWriter Stream
			
			// Adding "true" to our constructor (f, true) means we are going to "Append" the file, meaning ... 
			// ... it will add things in the end of it
			
			
			writer.write("---- List of Friends ----" + System.lineSeparator());
			for (String name : names)
			{
				writer.write(name); // Adding a Name
				writer.write(System.lineSeparator()); // Adding a line after each name 
			}
			
			writer.close(); // Closing our Writer
			
		} catch (IOException e) {
			e.printStackTrace(); // If there is an Exception there will be a Message in the console
		} 
		
		new GUI();
	}
}
