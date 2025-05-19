
public class Student {
	
	/* Fields */
	private String name;
	private String id;
	
	/* Constructors */
	public Student(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	// We override this "Default Object" method //
	// We want to print every object of Student class right away
	// Sometimes the method "toString()" is implied so in order to avoid this sort of issue we override it!!
	public String toString()
	{
		// Parentheses are not necessary when "returning"
		return name + ", " + id;
	}
	
	
	// We override this "Default Object" method //
	public boolean equals(Object obj)
	{
		// Casting Object as type Student so that we can use the its "id"
		Student student = (Student)obj;
		if (id.equals(student.id))
			return true; 
		return false;
	}
}
