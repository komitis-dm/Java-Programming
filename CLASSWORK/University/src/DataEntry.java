import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DataEntry {

	/* Other Methods */
	static void readData(ArrayList<Student> students)
	{
		while(true)
		{
		String type = JOptionPane.showInputDialog("Student type? 1=Stud, 2=Grad");
		// Converting "String to "Int"
		// The "String" to "Int" we have will ONLY work if the String is just numbers!!!
		int selection = Integer.parseInt(type);
			
		String name = JOptionPane.showInputDialog("Name?");
		String id = JOptionPane.showInputDialog("ID?");
		
		// We declare the Fields outside the "if" loop or else there is an error
		String supervisor = null;
		if (selection == 2)
			supervisor = JOptionPane.showInputDialog("Supervisor?");
		
		Student s;
		if (selection == 1)
			s = new Student(name, id);
		else
			s = new GraduateStudent(name, id, supervisor);
		
		students.add(s);
		
		// Continue??
		String answer = JOptionPane.showInputDialog("Continue (Y/N)?");
		//
		if (answer.equalsIgnoreCase("N"))
			break;
		}
	}
}
