import java.util.Scanner;

public class Product {
	
	// педиа - FIELDS 
	private String name;
	private double price;
	private int score;
	
	// Constructor
	public Product()
	{
		name = "";
		price = 1;
		score = 0;
	}
	
	// Reading
	public void read()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter product name:");
		name = keyboard.nextLine();
		System.out.print("Please enter product price:");
		price = keyboard.nextDouble();
		System.out.print("Please enter product score:");
		score = keyboard.nextInt();
	}
	// Comparison of products
	public boolean is_better_than(Product other)
	{
		if (score/price > other.score/other.price)
		{
			return true;
		}
		return false; 
		
		// return (score/price > other.score/other.price);
	}
	
	//Printing
	public void printData()
	{
		System.out.println("Best product name: " + name);
		System.out.println("Best product score: " + score);
		System.out.println("Best product price: " + price);
	}
	
}
