
public class Main {

	public static void main(String[] args) {
		
		Student s1 = new Student("NICK", "123");
		Student s2 = new Student("MARIA", "123");
		
		// See Student Class for explanation
		System.out.println(s1);
		
		// See Student Class for explanation
		if (s1.equals(s2))
			System.out.println("Same student");
		else
			System.out.println("Not the Same student");
		
		
	}
}
