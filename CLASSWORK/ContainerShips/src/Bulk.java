
public class Bulk extends Container {
	
	/* Field Declaration */
	private double weight;
	
	/* Constructor */
	public Bulk (String code, String destination,double weight)
	{
		super(code,destination);
		this.weight = weight;
	}
	
	/* Other Methods */
	public double getCharge()
	{
		return 10*weight;
	}
}
