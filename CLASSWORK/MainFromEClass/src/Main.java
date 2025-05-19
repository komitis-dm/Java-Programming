import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Collection<BankAccount> set = new TreeSet<>();
		
		BankAccount BA1 = new BankAccount("001", 1500, "Papadopoulos");
		BankAccount BA2 = new BankAccount("002", 2500, "Nikolaou");
		BankAccount BA3 = new BankAccount("003", 1000, "Petrou");
		
		set.add(BA1);
		set.add(BA2);
		set.add(BA3);
		
		for(BankAccount account: set) {
			
		   System.out.println(account.getId() + ", " + 
				              account.getBalance() + ", " +
				              account.getHolderName());
		}
			
		
	}
}
// We have to implement Comparable in order to be able to compare each BankAccount item
class BankAccount implements Comparable<BankAccount> {
	private String id;
	private double balance;
	private String holderName;
	
	public BankAccount(String id, double balance, String holderName) {
		this.id = id;
		this.balance = balance;
		this.holderName = holderName;
	}

	public String getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}

	public String getHolderName() {
		return holderName;
	}

	// Overrode method
	public int compareTo(BankAccount other) {
		
		//Comparing doubles
		// We can change the order if we change the "if" clauses
		/*
		if (this.balance < other.balance)
			return -1;
		else if (this.balance > other.balance)
			return 1;
		else
			return 0;
		*/
		
		// Comparing strings using the "compareTo" method
		return this.holderName.compareTo(other.holderName);
		
		
		
	}

}
