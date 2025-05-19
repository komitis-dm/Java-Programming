
public class Course {
	
	/* Variable Declaration */
	private String name;
	private int credits;
	private Student[] enrolledStudents = new Student[100];
	private int counter;
	
	/* Constructors */
	public Course(String text, int number)
	{
		name = text;
		credits = number;
		counter = 0;
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
	
	// �������� ������� ���� ������
	public void addStudent(Student s)
	{
		if (counter <enrolledStudents.length)
		{
			enrolledStudents[counter] = s;
			counter++;
		}
		else
			System.out.println("Course is full!");
	}	
	
	public void printCourseInfo()
	{
		System.out.println("Course: " + name);
		System.out.println("----------");
		System.out.println("Students:");
		for (int i=0; i < counter; i++ )
		{
			Student s = enrolledStudents[i];
			//s.printInfo();
			//OR:
			//enrolledStudents[i].printInfo();
			
			System.out.println(s.getName() + " (" +s.getId() +")");
		}
	}
}
