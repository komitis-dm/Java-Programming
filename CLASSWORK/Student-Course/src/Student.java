
public class Student {
	
	/* Variable Declaration */
	private String name;
	private String id;
	private Course myCourse;
	
	/* Constructors */
	public Student(String text1, String text2)
	{
		name = text1;
		id = text2;
	}
	public Student(String text1)
	{
		name = text1;
		id = "999";
	}
	
	/* Setters */
	public void setId(String anId)
	{
		id = anId;
	}
	// Το this χρησιμοποιείται γιατί έχουν το ίδιο όνομα 
	public void setMyCourse(Course myCourse) 
	{
		this.myCourse = myCourse;
	}
	
	/* Getters */
	public String getId()
	{
		return id;
	}
	
	/* Printer */
	public void printInfo()
	{	
		System.out.println("----------");
		System.out.println("Name: " + name);
		System.out.println("ID:" + id);
		// Το ίδιο πράγμα:
		// System.out.println("ID:" + getId());
		if (myCourse != null)
		{
			System.out.println("Course: " + myCourse.getName()); 
			System.out.println("Credits: " + myCourse.getCredits());
		}
		else
			System.out.println("No course selected!");
	}
}
