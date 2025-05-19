
public class Course {
	
	/* Variable Declaration */
	private String name;
	private int credits;
	
	/* Constructors */
	public Course(String text, int number)
	{
		name = text;
		credits = number;
	}
	
	/* Getters */
	public String getName() 
	{
		return name;
	}
	public int getCredits() 
	{
		return credits;
	}
	
	
}
