
public class GraduateStudent extends Student {
	
	/* Field Declaration */
	public String supervisor;
	
	/* Constructors */
	public GraduateStudent (String name, String id, String supervisor)
	{
		super (name, id);
		this.supervisor = supervisor;
	}
	
	/* Printers */
	public void printInfo()
	{
		super.printInfo();
		System.out.println("Supervisor: " + supervisor);
	}
}
