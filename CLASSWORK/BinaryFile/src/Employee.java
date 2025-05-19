import java.io.*;

public class Employee implements Serializable {
	
	/* Field Declaration */
	private String name;

	public Employee (String name)
	{
		this.name = name;
	}

	/* Getters/Setters */
	public String getName() {
		return name;
	}	
}
