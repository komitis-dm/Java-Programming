import java.util.Random;

public class Player {
	
	/* Variable Declaration */
	Random RAND = new Random();
	private int min = 2;
	private int max = 11;
	private int Card1 = RAND.nextInt(max-min) + min;
	private int Card2 = RAND.nextInt(max-min) + min;
	private int total = Card1 + Card2;	

	private int newCard = 0;
	
	/* Constructor */
	public Player ()
	{
		
	}
	
	/* Getter */
	public int getTotal() {
		return total;
	}
	public int getCard1() {
		return Card1;
	}
	public int getCard2() {
		return Card2;
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
