import java.util.Objects;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		/* Variable Declaration */
		Scanner keyboard = new Scanner(System.in);
		Player P = new Player();
		Dealer D = new Dealer();
		String answer = ""; 
		
		/* Input */
		System.out.println("Welcome to the simplified BlackJack game!!!");
		System.out.println("You get a "+ P.getCard1() + " and a "+ P.getCard2() + ".");
		System.out.println("Your total is " + P.getTotal() + ".\n");
		
		System.out.println("The dealer has a " + D.getShowingCard() + " and a hidden card.\n");
		
		// Player's Turn
		System.out.println("\nWould you like to " +"hit" +" or " + "stay?\n");
		answer = keyboard.next();
				
		while (!Objects.equals(answer,"stay"))
		{
			if (Objects.equals(answer,"hit"))
			{
				P.DrawCard();
				System.out.println("You drew a "+ P.getNewCard() + ".");
				System.out.println("Your total is " + P.getTotal() + ".");
				if (P.getTotal() > 21)
				{
					System.out.println("\nDEALER WINS!");
					System.exit(0);
				}
			}
			System.out.println("\nWould you like to " +"hit" +" or " + "stay?\n");
			answer = keyboard.next();
		}
				
		/* Computation */
		
		// Dealer's Turn
		System.out.println("OK, dealer is playing");
		System.out.println("His hidden card was " + D.getHiddenCard() + ".");
		System.out.println("His total is " + D.getTotal() + ".\n");
		
		while (true)
		{
			// This way the Dealer will risk going over 21, if the Player's total is higher than his...
			if (D.getTotal() < 16 | P.getTotal() > D.getTotal())
			{
				D.DrawCard();
				System.out.println("He draws a "+ D.getNewCard() + ".");
				System.out.println("His total is "+ D.getTotal() + ".\n");
				if (D.getTotal() > 21)
				{
					System.out.println("\n YOU WIN!");
					System.exit(0);
				}
			}
			else 
				break;

		}
		System.out.println("\nDealer stays.\n");		
				
		/* Output */
		System.out.println("Dealer's Total is: "+ D.getTotal() + ".");
		System.out.println("Your Total is: "+ P.getTotal()+ ".");
		
		if (D.getTotal() < P.getTotal())
		{
			System.out.println("\nYOU WIN!");
		}
		else
			System.out.println("\nDEALER WINS!");
	}
}
