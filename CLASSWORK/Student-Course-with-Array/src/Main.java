
public class Main {

	public static void main(String[] args) {
		
		/* Variable Declaration */
		
		// �� �������������� ��� ����� ������������
		Student s1 = new Student("NIKOS PAPADOPOULOS", "ics21100");
		// �� �������������� ��� ������� ������������
		Student s2 = new Student("MARIA PAPA");
		Course c1 = new Course ("Java", 5);
		Course c2 = new Course ("PHP", 5);
		
		/* Computation */
		s1.setMyCourse(c1);
		s2.setMyCourse(c1);
		
		c1.addStudent(s1);
		c1.addStudent(s2);
		
		/* Output */
		c1.printCourseInfo();
		

	}

}
