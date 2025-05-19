import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChargeCalculator extends JFrame {
	
	/* Field Declaration */
	private Ship ship;
	
	// Declare Panel 
	private JPanel panel;
	
	// Declare Button
	private JButton button;
	
	// Declare Text
	private JTextField text;
	
	
	/* Constructor */
	// We have added a Ship through the Constructor and we set it on a Field we created called "ship"
	public ChargeCalculator(Ship aShip)
	{
		panel = new JPanel();
		// We can use different types of JButton constructors. With this one you can add a text to it (there are others that can
		// things like color, images etc.)
		button = new JButton("Calculate Charge:");
		text = new JTextField("Total Charge for all containers:");
		ship = aShip;
		
		// The order in which I add the GUI elements on the panel is the order they will appear on it
		panel.add(button);
		panel.add(text);

		// Adds our Panel to a Window
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener);
		
		// Makes the Window visible
		this.setVisible(true);
		
		// Changes the size of the Window
		this.setSize(400,100);
		
		// Sets the title of the Window on the bar on top
		this.setTitle("Charge Calculator:");
		
		// EXIT_ON_CLOSE means the program ends when the Window is closed
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			// "setText" only works with Strings. The TotalCharge (a double number) needs to be converted to a String
			// To do this, we add a "+ ..." element which automatically creates a bigger string
			text.setText( ship.getTotalCharge() + " Euro" );
		}
	}
}
