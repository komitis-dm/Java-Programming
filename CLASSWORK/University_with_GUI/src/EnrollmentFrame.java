// The "*" means that we are accessing all the sub-folders of this Class
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// We need to extend our Class to JFrame to use its features
public class EnrollmentFrame extends JFrame {
	
	/* Field Declaration */
	private JPanel panel;
	private JTextField nameField;
	private JTextField courseField;
	private JButton enrollButton;
	private JButton printCourseButton;
	
	// We need this field to add an ArrayList from Main Class through the Constructor
	private ArrayList<Course> courses = new ArrayList<>();
	
	private int counter = 0;
	
	/* Constructors */
	public EnrollmentFrame(ArrayList<Course> courses)
	{
		this.courses = courses;
		
		// We create this Panel were all of our Fields and Buttons will go on
		panel = new JPanel();
		
		// Create GUI Elements (JTextFields and JButtons)
		nameField = new JTextField(10);
		courseField = new JTextField(10);
		enrollButton = new JButton("Enroll in");
		printCourseButton = new JButton("Print Course Students");
		
		// We add them to the panel in the order that we want them to appear
		panel.add(nameField);
		panel.add(enrollButton);
		panel.add(courseField);
		panel.add(printCourseButton);
		
		// Check if the user presses one of the two Buttons
		ButtonListener listener = new ButtonListener();
		enrollButton.addActionListener(listener);
		printCourseButton.addActionListener(listener);
		
		// We add our panel to our Window
		this.setContentPane(panel);
		
		// Set Panel Visibility (True/False)??
		this.setVisible(true);
		
		// Set Panel Size (Width, Length)??
		this.setSize(400, 300);
		
		// Set Panel Title
		this.setTitle("Student Enrollment");
		
		// Set Panel's ability to Resize (True/False)??
		this.setResizable(false);
		
		// This means that if we close the main window everything closes
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
	
	// Class inside a Class (Internal Class)
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			
			// The method "getText()" is used to get the courseField
			String courseTitle = courseField.getText();
			
			Course selectedCourse = null;
			
			for(Course c : courses)
			{
				if (c.getTitle().equals(courseTitle))
				{
					selectedCourse = c;
					break;
				}
			}
			if (selectedCourse != null)
			{
				// enrollButton was pressed
				if ( e.getSource().equals(enrollButton))
				{
					String name = nameField.getText();
					counter++;
					// Counter is used to display the number of Student (eg. dai2033)
					String am = "dai20" + counter;
					Student s = new Student (name, am);
					selectedCourse.addStudent(s);					
				}
				
				// printCourseButton was pressed
				else
				{
					selectedCourse.printCourseDetails();
				}
			}
			else
				// The first parameter shows where the message will appear (in this case in the panel)
				JOptionPane.showMessageDialog(panel, "Something went wrong");
		}
	}
}
