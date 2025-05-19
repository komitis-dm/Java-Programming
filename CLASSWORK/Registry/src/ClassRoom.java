
public class ClassRoom {
	
	/* Variable Declaration */
	String location;
	int capacity;
	
	/* Constructors */
	public ClassRoom(String location, int capacity)
	{
		this.location = location;
		this.capacity = capacity;
	}

	/* Getters */
	public String getLocation() {
		return location;
	}
	
	public int getCapacity() {
		return capacity;
	}

	/* Setters */
	public void setLocation(String location) {
		this.location = location;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
