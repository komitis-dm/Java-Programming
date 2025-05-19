
public abstract class Container {
	
	/* Field Declaration */
	private String code;
	private String destination;
	
	/* Constructor */
	public Container (String code, String destination)
	{
		this.code = code;
		this.destination = destination;
	}
	
	/* Adders */
	// Abstract Method that will be overrode in the subClasses
	public abstract double getCharge();
	
	/* Setters-Getters */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}
