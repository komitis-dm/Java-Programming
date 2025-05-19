import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		/*
		Student s1 = new Student("NIKOS", "ics20100");
		Course c1 = new Course("Java", 5);
		Course c2 = new Course("C++", 5);
		
		s1.addCourse(c1);
		s1.addCourse(c2);
		s1.printInfo();
		
		Student s2 = new GraduateStudent("MARIA","iis20123", "Dr. PETROS");
		s2.addCourse(c1);
		s2.printInfo();
		*/
		
		ArrayList<Student> students = new ArrayList<>();
		//We code like this if we make the Method "public"
		//DataEntry data = new DataEntry();
		//data.readData(students);
		
		//We code like this if we make the Method "static"
		DataEntry.readData(students);
		
		for (Student s : students)
			s.printInfo();	
	}

}
