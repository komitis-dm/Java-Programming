
public class PhoneCall extends Communication {
	
	/* Field Declaration */
	int duration;
	
	/* Constructors */
	public PhoneCall(String number1, String number2, int day, int month, int year, int duration)
	{
		super(number1, number2, day, month, year);
		this.duration = duration;
	}
	
	/* Printers */
	public void printInfo()
	{
		System.out.println("This phone call has the following info");
		super.printInfo();
		System.out.println("Duration: " + duration);
	}

	/* Getters-Setters */
	public int getDuration() {
		return duration;
	}
}
