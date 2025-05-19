
public class Main {

	public static void main(String[] args) {
		
		/* Variable Declaration */
		
		ClassRoom Lab = new ClassRoom("LAB-334",35);
		ClassRoom Lab2 = new ClassRoom("LAB-KYD",65);
		ClassRoom Lab3 = new ClassRoom("LAB-224",35); 
		Student s1 = new Student("DIMITRIOS KOMITIS", "iis21146");
		Student s2 = new Student("ANTHONY STARK","iis21147");
		Student s3 = new Student("STEVEN ROGERS","iis21148");
		Course c1 = new Course ("Java", 5);
		Course c2 = new Course ("Computer Systems", 5);
		Course c3 = new Course ("Computer Networks", 5);
		Registry r1 = new Registry ("Applied Infomratics");
		
		/* Computation */
		c1.setMyClassRoom(Lab);
		c2.setMyClassRoom(Lab2);
		c3.setMyClassRoom(Lab3);
		
		s1.setMyCourse(c1);
		s2.setMyCourse(c1);
		s3.setMyCourse(c1);
		
		c1.addStudent(s1);
		c1.addStudent(s2);
		c1.addStudent(s3);
		
		r1.addCourse(c1);
		r1.addCourse(c2);
		r1.addCourse(c3);
			
			
		/* Output */
		
		/*
		s1.printBasicInfo();
		s2.printBasicInfo();
		s3.printBasicInfo();
		*/
		r1.printRegistry();
		
		/*
		System.out.println("");
		c1.printCourseName();
		c1.printClassRoom();
		c1.printCourseStudents();
		*/
	}

}
