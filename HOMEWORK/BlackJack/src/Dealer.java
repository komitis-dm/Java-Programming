import java.util.Random;

public class Dealer {

	/* Variable Declaration */
	Random RAND = new Random();
	private int min = 2;
	private int max = 11;
	private int ShowingCard = RAND.nextInt(max-min) + min;
	private int HiddenCard = RAND.nextInt(max-min) + min;
	private int total = ShowingCard + HiddenCard;
	
	private int newCard = 0;

	/* Constructor */
	public Dealer ()
	{
		
	}
	
	/* Getters */
	public int getTotal() {
		return total; 
	}
	public int getShowingCard() {
		return ShowingCard;
	}
	public int getHiddenCard() {
		return HiddenCard;
	}
	public int getNewCard() {
		return newCard;
	}
	
	public void DrawCard()
	{
		newCard = RAND.nextInt(max-min) + min;
		total = total + newCard;
	}
	
}
