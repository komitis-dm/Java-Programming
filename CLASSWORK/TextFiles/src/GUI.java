import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class GUI extends JFrame {
	
	/* Element Declaration */
	private JPanel panel = new JPanel();
	private JButton button = new JButton("Open File");
	private JFileChooser fc = new JFileChooser(); // Already set GUI Element that opens up File Chooser
	

	public GUI()
	{
		panel.add(button);
		
		ButtonListener listener = new ButtonListener();
		button.addActionListener(listener);
		
		this.setContentPane(panel);
		this.setSize(500,500);
		this.setVisible(true);
		
	}
	
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
			int returnVal = fc.showOpenDialog(panel); // (null) adds the window in the middle of the screen
													  // (panel) adds the window inside the panel
			// returnVal shows what the user picked during the 
			
			if (returnVal == JFileChooser.OPEN_DIALOG)
			{
				File file = fc.getSelectedFile(); // Through this method the file the user chose is returned
				
				try {
					FileReader fr = new FileReader(file); // Adding our File to a FileReader Stream
					BufferedReader reader = new BufferedReader(fr); // We need to add our FileReader (fr) for this BufferedReader to work
					
					String line = reader.readLine(); // Reading every line
					while (line != null) // While we are not on the last line
					{
						System.out.println(line);
						line = reader.readLine();
					}

					fr.close(); // Closing our Reader
					reader.close(); // Closing our other Reader
					
				} catch (IOException e) {
					e.printStackTrace(); // If there is an Exception there will be a Message in the console
				}
			}
			
		}
		
	}
}
