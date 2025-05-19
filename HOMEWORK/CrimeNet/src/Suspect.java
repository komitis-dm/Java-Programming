import java.util.ArrayList;

public class Suspect {
	
	/* Field Declaration */
	private String name;
	private String codeName;
	private String city;
	private ArrayList <String> numList = new ArrayList<>();
	private ArrayList<Suspect> possiblePartners = new ArrayList<>();
	
	/* Constructors */
	public Suspect(String name, String codeName, String city)
	{
		this.name = name;
		this.codeName = codeName;
		this.city = city;
	}
	
	/* Add */
	public void addNumber(String number)
	{
		numList.add(number);
	}
	
	public void addPossibleSuspect (Suspect aSuspect)
	{
		for (Suspect ps: possiblePartners)
		{
			if (ps.equals(aSuspect))
			{
				return;
			}
		}
		possiblePartners.add(aSuspect);
	}
	
	/* Other Methods */
	public boolean isConnectedTo (Suspect aSuspect)
	{
		for (Suspect ps: possiblePartners) 
		{
			if ((ps.getName()).equals(aSuspect.getName()))
			{
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect)
	{
		ArrayList<Suspect> pc = new ArrayList<>();
		
		for (Suspect s : possiblePartners)
		{
				if ( (s.isConnectedTo(aSuspect)) )
				{
					pc.add(s);
				}
		}
		return pc;
	}
	
	/* Printers */
	public void printPossiblePartners()
	{
		System.out.println("Possible Partners: ");
		for (Suspect pp : possiblePartners)
		{
			System.out.println(pp.getName());
		}
	}
	
	/* Getters-Setters */
	public String getName() {
		return name;
	}
	public String getCodeName() {
		return codeName;
	}
	public ArrayList<String> getNumList() {
		return numList;
	}
	public ArrayList<Suspect> getPossiblePartners() {
		return possiblePartners;
	}	
}
