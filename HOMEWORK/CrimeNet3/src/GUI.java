import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Color;
import javax.swing.border.Border;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.shortestpath.*;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.event.GraphEvent.Edge;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.Vertex;
import edu.uci.ics.jung.algorithms.metrics.*;
import java.lang.Object.*;
import java.util.List;

public class GUI extends JFrame {

	private Registry registry;
	
	/* Frame #1 */
	private JFrame FindSuspectFrame = new JFrame("Find Suspect");
	private JPanel FindSuspectPanel = new JPanel();
	private JTextField text = new JTextField("Please enter suspect's name:");
	private JButton button = new JButton("Find");	
	private JButton button2 = new JButton("Vizualize Network");
	
	/* Constructor */
	public GUI (Registry aRegistry)
	{
		registry = aRegistry;
		
		// Frame #1
		FindSuspectPanel.add(text);
		FindSuspectPanel.add(button);
		FindSuspectPanel.add(button2);
		FindSuspectFrame.add(FindSuspectPanel);	
		FindSuspectFrame.setVisible(true);
		FindSuspectFrame.setSize(300,110);
		FindSuspectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FindButton listener = new FindButton(); // LISTENER
		button.addActionListener(listener);	
		
		VisButton listener2 = new VisButton(); // LISTENER
		button2.addActionListener(listener2);		
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
	class VisButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			FindSuspectFrame.dispose(); // Closing the old Frame
			Graph<String, String> g = new UndirectedSparseGraph<>(); // Create Graph
			
			for (Suspect s : registry.getSusList())
			{	
				if (!g.containsVertex(s.getCodeName()))
					g.addVertex(s.getCodeName());
				for (Suspect p : s.getPossiblePartners())
				{
					if ( !g.containsEdge(s.getCodeName() + ", " + p.getCodeName()) ||
						 !g.containsEdge(p.getCodeName() + ", " + s.getCodeName()))
						g.addEdge(s.getCodeName() + ", " + p.getCodeName(),
								  s.getCodeName(), p.getCodeName());
				}
			}
			
			// Finding Diameter
			DijkstraShortestPath<String,String> DijPath = new DijkstraShortestPath(g);
			double max = 0.0;
			for (String s: g.getVertices())
			{
				//System.out.println(s);
				for (String s2 : g.getVertices())
				{
					if (!s.equals(s2))
					{
						double dist = (double) DijPath.getDistance(s, s2);
						if (dist > max)
						{
							max = dist;
						}
					}
				}
			}
			double diameter = max;
			
			
			// Frame #2.1
			Border border = BorderFactory.createLineBorder(Color.gray);
			JFrame frame = new JFrame("Suspects Network");

			JPanel mainPanel = new JPanel();
			JTextArea text = new JTextArea();
			text.setBorder(border);
			text.setText("Diameter = "+ diameter);
			//text.setPreferredSize( new Dimension(100,20) );
			
			
			// Put Graph on our panel
			frame.setLayout(new BorderLayout());
			
			Layout<String,String> layout = 
					 new CircleLayout<String,String>(g);
			layout.setSize(new Dimension(300,300));
			BasicVisualizationServer<String,String> vv = 
					 new BasicVisualizationServer<String,String>(layout);
			vv.setPreferredSize(new Dimension (350,350));
			vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
				
			frame.add(vv, BorderLayout.NORTH);
			frame.add(text, BorderLayout.SOUTH);
		
			frame.setVisible(true);
			frame.setSize(400,420);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			// setVertexLabelTransformer();
			// setVertexLabelTransformer(new ToStringLabeller);
			
		}
	}
}
