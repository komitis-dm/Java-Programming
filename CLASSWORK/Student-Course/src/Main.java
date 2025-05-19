
public class Main {

	public static void main(String[] args) {
		
		/* Variable Declaration */
		//ΑΑΑΑΑΑ
		// Èá ÷ñçóéìïðïéÞóåé ôïí ðñþôï êáôáóêåõáóôÞ
		Student s1 = new Student("NIKOS PAPADOPOULOS", "ics21100");
		// Èá ÷ñçóéìïðïéÞóåé ôïí äåýôåñï êáôáóêåõáóôÞ
		Student s2 = new Student("MARIA PAPA");
		Course c1 = new Course ("Java", 5);
		Course c2 = new Course ("PHP", 5);
		
		/* Computation */
		s1.setMyCourse(c1);
		s2.setMyCourse(c2);
		
		s2.setId("iis21123");
		System.out.println("New Id: " + s2.getId());
		
		/* Output */
		s1.printInfo();
		s2.printInfo();
		

	}

}
