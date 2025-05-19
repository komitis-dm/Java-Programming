import java.util.ArrayList;

public class Course {
	
	/* Variable Declaration */
	private String name;
	private int credits;
	private ArrayList<Student> enrolledStudents = new ArrayList<>();
	private ClassRoom myClassRoom;
	
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
	
	/* Setters */
	public void setName(String name) {
		this.name = name;
	}
	
	// Add Students
	public void addStudent(Student s)
	{
		if (enrolledStudents.size() < myClassRoom.getCapacity())
		{
			enrolledStudents.add(s);
			s.setMyCourse(this);	
		}
		else
			System.out.println("Course is full!");
	}	
	
	// Change Class Room
	public void setMyClassRoom(ClassRoom myClassRoom) {
		this.myClassRoom = myClassRoom;
	}
	
	/* Printers */
	public void printCourseStudents()
	{
		System.out.println("Students:");
		
		for(Student s : enrolledStudents)
		{
			s.printBasicInfo();
		}
	}

	public void printCourseName()
	{
		System.out.println("Course: " + name);
	}

	public void printClassRoom()
	{
		System.out.println("Class Room:" + myClassRoom.getLocation());
	}
}
