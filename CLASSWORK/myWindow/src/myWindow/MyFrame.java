package myWindow;

// The "*" makes us use all the extensions in the folder
import javax.swing.*;

//OR

/*
import javax.swing.JFrame;
import javax.swing.JPanel;
*/

public class MyFrame extends JFrame {
	
	private JPanel panel;
	private JTextField textField;
	private JButton button;
	
	public MyFrame() 
	{
		panel = new JPanel();
		textField = new JTextField(10);
		button = new JButton("Press me");
		
		// If True --> the frame is visible to the user
		this.setVisible(true);
		this.setSize(300,300);
		this.setTitle("HEYYYY...WHAT YOU DEALIN WITH");
	}

}
