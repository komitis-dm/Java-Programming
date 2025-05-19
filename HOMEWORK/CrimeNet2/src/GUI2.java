import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;

public class GUI2 extends JFrame {
	
	/* Field Declaration */
	private Registry registry;
	private String text;
	private Suspect Sus;
	private ArrayList<SMS> smsList = new ArrayList<>(); 
	private Border border = BorderFactory.createLineBorder(Color.gray); // Border Declaration
	
	/* Frame #2 */
	private JFrame SuspectPageFrame = new JFrame("Suspect Page");

	//Main Panel
	private JPanel mainPanel = new JPanel();
	
	//Panel A
	private JPanel panelA = new JPanel();
	private JTextField textA1 = new JTextField();
	private JTextField textA2 = new JTextField();
	private JTextArea textA3 = new JTextArea();
	
	// Panel B
	private JPanel panelB = new JPanel();
	private JTextField textB1 = new JTextField();
	private JTextArea textB2 = new JTextArea();
	private JButton buttonB = new JButton("Find SMS");
	
	// Panel C
	private JPanel panelC = new JPanel();
	private JLabel textC1 = new JLabel("Partners:");
	private JTextArea textC2 = new JTextArea();
	
	// Panel D
	private JPanel panelD = new JPanel();
	private JLabel textD1 = new JLabel("Suggested Partners:");
	private JTextArea textD2 = new JTextArea();
	
	// Panel E
	private JPanel panelE = new JPanel();
	private JButton buttonE = new JButton("Back to Search Screen");
	
	/* Constructor */
	public GUI2 (Registry aRegistry, String aText)
	{
		registry = aRegistry;
		text = aText;
		
		// Associating the text with a Suspect
		for (Suspect s : registry.getSusList())
		{	
			if( text.equals(s.getName()) )
			{
				Sus = s;
				break;
			}	
		}	

		// Frame #2
		mainPanel.add(panelA);
		mainPanel.add(panelB);
		mainPanel.add(panelC);
		mainPanel.add(panelD);
		mainPanel.add(panelE);
		
		SuspectPageFrame.add(mainPanel);
		
		
		// Panel A 
		textA1.setPreferredSize(new Dimension (100,20)); // Field Dimensions
		textA2.setPreferredSize(new Dimension (100,20));
		textA3.setPreferredSize(new Dimension (100,50));
		textA1.setHorizontalAlignment(JTextField.CENTER);
		
		textA3.setBorder(border);
		textA1.setText(Sus.getName());					 // Set Texts
		textA2.setText(Sus.getCodeName());
		for(String num : Sus.getNumList())
		{
			
			textA3.append(num);
			textA3.append("\n");
		}
		panelA.add(textA1);								// Add Fields
		panelA.add(textA2);
		panelA.add(textA3);
		panelA.setBorder(border);
		
		// Panel B
		textB1.setPreferredSize(new Dimension (110,20));
		textB2.setPreferredSize(new Dimension (230,150));
		textB2.setBorder(border);
		//textB1.setText("00446999888888");
		panelB.add(textB1);
		panelB.add(textB2);
		panelB.add(buttonB);
		panelB.setBorder(border);
		SMSButton listener = new SMSButton(); 		// LISTENER
		buttonB.addActionListener(listener);
		
		// Panel C
		textC2.setPreferredSize(new Dimension (200,150));
		textC2.setBorder(border);
		List<String> stringList = new ArrayList<>();          // List implemented as an ArrayList (we can add elements normally)
		for (Suspect s : Sus.getPossiblePartners())
		{
			stringList.add(s.getName() + ", " + s.getCodeName());
		}
		Collections.sort(stringList, new SortComparator());  // Compares the elements of the List according to the way we set in the SortComparator Class
		for (String s : stringList)
		{
			textC2.append(s);
			textC2.append("\n");
		}
		panelC.add(textC1);
		panelC.add(textC2);	
		panelC.setBorder(border);
		
		// Panel D
		textD2.setPreferredSize(new Dimension (200,80));
		textD2.setBorder(border);
		//.
		//.
		//.
		panelD.add(textD1);
		panelD.add(textD2);
		panelD.setBorder(border);
		
		// Panel E
		panelE.add(buttonE);
		
		ReturnButton listener2 = new ReturnButton(); // LISTENER
		buttonE.addActionListener(listener2);
		
		// Frame Stuff
		SuspectPageFrame.setVisible(true);
		SuspectPageFrame.setSize(500,580);
		SuspectPageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// ACTION CLASSES
	public class ReturnButton implements ActionListener			// Button that "Returns to Search Screen"
	{
		public void actionPerformed(ActionEvent e)
		{
			SuspectPageFrame.dispose();
			new GUI(registry);
		}
	}
	public class SMSButton implements ActionListener			// Button that "Finds SMSs"
	{
		public void actionPerformed(ActionEvent e)
		{
			for (Communication c : registry.getComList())
			{
				for (String num : Sus.getNumList())
				{
					if (c instanceof SMS)
					{
						String num1 = c.getNumber1();
						String num2 = c.getNumber2();
						if ( ( num1.equals(num) && num2.equals(textB1.getText()) ) ||
							 ( num2.equals(num) && num1.equals(textB1.getText()) ) )
						{
							if (  (((SMS)c).getMessage()).contains("Bomb")       ||
									  (((SMS)c).getMessage()).contains("Attack")     ||
									  (((SMS)c).getMessage()).contains("Explosives") ||
									  (((SMS)c).getMessage()).contains("Gun")  )
								{
									smsList.add((SMS)c);
								}
						}
					}
				}
			}
			for (SMS s : smsList)
			{
				textB2.append(s.getMessage());
				textB2.append("\n");
			}
		}
	}
	
}
