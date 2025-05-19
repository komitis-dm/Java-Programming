import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		
		// Δημιουργία Αντικειμένου // 
		Scanner in = new Scanner(System.in);  
		
		/* Variable Declaration */
		
		//Βέλτιστο Προϊόν//
		String bestName = "";
		double bestPrice = 1;
		int bestScore = 0;
		
		boolean more = true;
		
		/* Input */
		while(more) {
			
			//Τρέχον Προϊόν//
			String name;
			double price;
			int score;
			
			System.out.println("Please enter the model: ");
			name = in.nextLine();
			System.out.println("Please enter the price: ");
			price = in.nextDouble();
			System.out.println("Please enter the score:");
			score = in.nextInt();
			
			if(score/price > bestScore/bestPrice) {
				bestName = name;
				bestPrice = price;
				bestScore = score;
			}
			
			System.out.println("More Products? 1:YES, 2: NO");
			int answer = in.nextInt();
			if (answer != 1)
				more = false;
			in.nextLine();
		}
		System.out.println("BEST PRODUCT");
		System.out.println("Name: " + bestName);
		System.out.println("Price: " + bestPrice);
		System.out.println("Source: " + bestScore);
	}
}