
public class Course {

	/* Field Declaration */
	private String name;
	private int credits;
	
	/* Constructors */
	public Course(String name, int credits)
	{
		this.name = name;
		this.credits = credits;
	}
	
	/* Getters-Setters */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}	
}
