
public class SMS extends Communication {
	
	/* Field Declaration */
	String message;
	
	/* Constructors */
	public SMS (String number1, String number2, int day, int month, int year, String message)
	{
		super(number1, number2, day, month, year);
		this.message = message;
	}

	/* Printers */
	public void printInfo()
	{
		System.out.println("This SMS has the following info");
		super.printInfo();
		System.out.println("Text: " + message);
	}
	
	/* Getters - Setters */
	public String getMessage() {
		return message;
	}
}
