import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		/* Variable Declaration in Class */
		Product best = new Product();
		Product current = new Product();
		
		/* Variable Declaration */
		boolean more = true;
		
		/* Input */
		while(more)
		{			
			current.read();
			
			// Comparison
			if (current.is_better_than(best))
			{
				best = current;
			}
			
			
			System.out.println("Continue yes=1 or no=2?");
			int answer = keyboard.nextInt();
			if ( answer == 2)
			{
				more = false;
			}
			keyboard.nextLine();
		}
		
		/* Output */
		best.printData();	
	}
}
