import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame {

	private Registry registry;
	
	/* Frame #1 */
	private JFrame FindSuspectFrame = new JFrame("Find Suspect");
	private JPanel FindSuspectPanel = new JPanel();
	private JTextField text = new JTextField("Please enter suspect's name:");
	private JButton button = new JButton("Find");	
	
	/* Constructor */
	public GUI (Registry aRegistry)
	{
		registry = aRegistry;
		
		// Frame #1
		FindSuspectPanel.add(text);
		FindSuspectPanel.add(button);
		FindSuspectFrame.add(FindSuspectPanel);		
		FindSuspectFrame.setVisible(true);
		FindSuspectFrame.setSize(300,100);
		FindSuspectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FindButton listener = new FindButton(); // LISTENER
		button.addActionListener(listener);	
	}
	
	
	
	// ACTION CLASSES
	class FindButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			boolean found = false; 	// Found Variable

			
			// Going through every Suspect 
			for (Suspect s : registry.getSusList())
			{	
				// Checking if the Suspect's name is the same as the Text from the TextField
				if ( text.getText().equals(s.getName()) )
					found = true;
			}
			
			if (found == false)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Suspect " + text.getText() + " Not Found" , "Message",
				        JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				FindSuspectFrame.dispose();
				new GUI2(registry, text.getText());
			}
		}
	}	
}
