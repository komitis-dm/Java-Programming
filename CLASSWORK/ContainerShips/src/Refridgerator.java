
public class Refridgerator extends Container {

	/* Field Declaration */
	private double power;
	
	/* Constructor */
	public Refridgerator (String code, String destination,double power)
	{
		super(code,destination);
		this.power = power;
	}
	
	/* Other Methods */
	public double getCharge()
	{
		return 2000*power;
	}
}
