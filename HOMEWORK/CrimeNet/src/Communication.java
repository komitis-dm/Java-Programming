
public abstract class Communication {
	
	/* Field Declaration */
	protected String number1;
	protected String number2;
	protected int day;
	protected int month;
	protected int year;
	
	/* Constructors */
	public Communication(String number1, String number2, int day, int month, int year)
	{
		this.number1 = number1;
		this.number2 = number2;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	/* Other Methods */
	
	/* Printers */
	public void printInfo()
	{
		System.out.println("Between " + number1 + " --- " + number2);
		System.out.println("on " + day + "/" + month + "/" + year);
	}
	
	/* Getters-Setters*/
	public String getNumber1() {
		return number1;
	}
	public String getNumber2() {
		return number2;
	}
}
