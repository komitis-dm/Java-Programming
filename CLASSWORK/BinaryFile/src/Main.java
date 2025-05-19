import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		Employee e = new Employee("Nikos");
		
		
		try {
			
			FileOutputStream fileOut = new FileOutputStream("employee.ser"); //We can either create the file by adding the name as so ...
																			 // ... or add a (new File())
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			out.writeObject(e); // Sending an Object to the Binary File
			
			fileOut.close();
			out.close();
			
			
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		
		try {
			
			FileInputStream fileIn = new FileInputStream("employee.ser"); 
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			Employee emp = (Employee)in.readObject(); // Reading an Object from the Binary File...
													  // ... we cast to associate the Object with Employee
			System.out.println(emp.getName());
			
			fileIn.close();
			in.close();
			
			
		} catch(IOException exc) {
			exc.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}
