import java.util.ArrayList;

public class Student {

	/* Field Declaration */
	protected String name;
	protected String id;
	protected ArrayList<Course> courses = new ArrayList<>();
	
	/* Constructors */
	public Student(String name, String id)
	{
		this.name = name;
		this.id = id;
	}
	
	/* Other Methods */
	public void addCourse(Course c)
	{
		courses.add(c);
	}
	
	/* Printers */
	public void printInfo()
	{
		System.out.println(name + " (" + id + ")");
		for (Course c: courses)
		{
			System.out.println(c.getName() + ", " + 
							   c.getCredits() + " ects");
		}
	}
}
