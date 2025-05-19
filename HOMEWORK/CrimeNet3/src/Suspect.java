import java.util.ArrayList;

public class Suspect {
	
	/* Field Declaration */
	private String name;
	private String codeName;
	@SuppressWarnings("unused")
	private String city;
	private ArrayList <String> numList = new ArrayList<>();
	private ArrayList<Suspect> possiblePartners = new ArrayList<>();
	private ArrayList<Suspect> suggestedPartners =new ArrayList<>();
	
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
		aSuspect.getPossiblePartners().add(this);
	}
	
	/* Other Methods */
	public boolean isPossiblePartner (Suspect aSuspect)
	{
		for (Suspect s : this.getPossiblePartners())
		{
			if (s.equals(aSuspect))
			{
				return true;
			}
		}
		return false;
	}
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
	public ArrayList<Suspect> getSuggestedPartners()
	{
		for (Suspect s : ( this.getPossiblePartners()) )
		{
			for (Suspect pp : s.getPossiblePartners() )
			{
				if (!pp.isConnectedTo(this) && !pp.equals(this) && !pp.inList(suggestedPartners))
				{
					suggestedPartners.add(pp);
				}
			}
		}
		return suggestedPartners;
	}
	public boolean inList(ArrayList<Suspect> aList) //Checking if the Suspect is already in a List
	{
		for (Suspect s : aList)
		{
			if (s.equals(this))
			{
				return true;
			}
		}
		return false;
	}
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
