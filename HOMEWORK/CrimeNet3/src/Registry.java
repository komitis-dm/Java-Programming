import java.util.ArrayList;

public class Registry {
	
	/* Field Declaration */
	private ArrayList<Suspect> susList = new ArrayList<>();
	private ArrayList<Communication> comList = new ArrayList<>();

	/* Constructors */
	public Registry()
	{
	}
	
	/* Add */
	public void addSuspect (Suspect aSuspect)
	{
		susList.add(aSuspect);
	}
	public void addCommunication(Communication aCommunication)
	{			
		comList.add(aCommunication);
		String Num1 = aCommunication.getNumber1();
		String Num2 = aCommunication.getNumber2();
		
		Suspect sus1 = new Suspect ("","","");
		Suspect sus2 = new Suspect ("","","");
		
		// Going through all Suspects
		for (Suspect s : susList)
		{
			// Going through every Suspect's Phone Number
			for (String n : s.getNumList())
			{
				if (n.equals(Num1))
				{
					sus1 = s;
				}
				if (n.equals(Num2))
				{
					sus2 = s;
				}
			}
		}
		if (!sus1.isConnectedTo(sus2))
		{
			sus1.addPossibleSuspect(sus2);
			sus2.addPossibleSuspect(sus1);
		}
	}
	
	/* Other Methods */
	public Suspect getSuspectWithMostPartners()
	{
		Suspect s = new Suspect("","","");
		int max = 0;
		
		for(Suspect SUS: susList)
		{
			if ((SUS.getPossiblePartners().size() >= max))
			{
				s = SUS;
				max = SUS.getPossiblePartners().size();
			}	
		}
		return s;
	}
	public PhoneCall getLongestPhoneCallBetween (String number1, String number2)
	{
		PhoneCall pc = new PhoneCall ("","", 0, 0, 0, 0);
		int max = 0;
		
		for (Communication c : comList)
		{
			// Is this Communication Object an Object of SubCLass "PhoneCall" ??
			if (c instanceof PhoneCall)
			{
				if (  ((PhoneCall)c).getDuration() > max &&
						  c.getNumber1().equals(number1) && 
						  c.getNumber2().equals(number2)  )  
				{
					pc = (PhoneCall)c;
					max = ((PhoneCall)c).getDuration();
				}
			}
		}
		return pc;
	}
	public ArrayList<SMS> getMessagesBetween (String number1, String number2)
	{
		ArrayList<SMS> smsList = new ArrayList<>();
		
		for (Communication c :comList)
		{
			// Is this Communication Object an Object of SubCLass "SMS" ??
			if (c instanceof SMS)
			{
				if ( ( c.getNumber1().equals(number1) && c.getNumber2().equals(number2) ) || 
						 ( c.getNumber2().equals(number1) && c.getNumber1().equals(number2) ) )	
				{
					// Does it have the characters in it???
					if (  (((SMS)c).getMessage()).contains("Bomb")       ||
						  (((SMS)c).getMessage()).contains("Attack")     ||
						  (((SMS)c).getMessage()).contains("Explosives") ||
						  (((SMS)c).getMessage()).contains("Gun")  )
					{
						smsList.add((SMS)c);
					}
				}
			}

		}
		
		return smsList;
	}
	
	/* Printers */
	public void printRegistry()
	{
		for (Communication c : comList)
		{
			c.printInfo();
			System.out.println("");
		}
	}
	
	/* Getters-Setters */
	public ArrayList<Suspect> getSusList() {
		return susList;
	}
	public ArrayList<Communication> getComList() {
		return comList;
	}
}
