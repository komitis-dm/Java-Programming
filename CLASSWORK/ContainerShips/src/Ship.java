import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ship {
	
	/* Field Declaration */
	private int capacity;
	private String name;
	private ArrayList<Container> containers = new ArrayList<>();
	
	/* Constructors */
	public Ship(String name, int capacity)
	{
		this.name = name;
		this.capacity = capacity;
	}
	
	/* Other Methods */
	public void addContainer(Container c)
	{
		if (capacity > containers.size())
			containers.add(c);
		else
			// If we set the first argument as null, the message will show up in the middle of the screen
			JOptionPane.showMessageDialog(null, "Sorry, Ship is Full!" );
	}
	
	public double getTotalCharge()
	{
		double total = 0;
		for (Container aContainer : containers)
		{
			total += aContainer.getCharge();
		}
		return total;
	}
	
}
