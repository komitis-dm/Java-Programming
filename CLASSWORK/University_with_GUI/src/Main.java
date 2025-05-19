import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Course> courses;
		
		courses = new ArrayList<Course>();
		courses.add(new Course("C", "Satratzemi"));
		courses.add(new Course("HTML", "Kaskalis"));
		
		// If we leave it like this it's called an "Unnamed Object"
		// new EnrollmentFrame();
		
		EnrollmentFrame frame = new EnrollmentFrame (courses);	
	}
}

