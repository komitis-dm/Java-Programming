import java.util.ArrayList;

public class Registry {

	/* Variable Declaration */
	private String name;
	private ArrayList<Course> courses = new ArrayList<>();
	
	/* Constructors */
	public Registry (String name)
	{
		this.name = name;
	}

	/* Setters */
	public void setName(String name) {
		this.name = name;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	/* Getters */
	public String getName() {
		return name;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	//
	public void addCourse(Course c)
	{
		courses.add(c);
	}
	
	/* Printers */
	public void printRegistry()
	{
		System.out.println("Courses:");
		for (int i=0; i< courses.size(); i++)
		{
			Course A = courses.get(i);
			System.out.println(""+ A.getName());
		}

		for (int i=0; i< courses.size(); i++)
		{
			Course A = courses.get(i);
			System.out.println("----------");
			System.out.println(""+ A.getName() + ":");
			A.printClassRoom();
			A.printCourseStudents();
		}
	}
}
