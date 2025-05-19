
public class Main {

	public static void main(String[] args) {
	
		/* Variable Declaration */
		Ship ship = new Ship("X", 450);
		
		Bulk container1 = new Bulk("XYZ123", "Barcelona", 980);
		Bulk container2 = new Bulk("ABC6573", "Piraeus", 1500);
		Refridgerator container3 = new Refridgerator ("KL345", "Chania", 11.5);
		Refridgerator container4 = new Refridgerator ("ASK671", "Genova", 9.4);
		
		
		ship.addContainer(container1);
		ship.addContainer(container2);
		ship.addContainer(container3);
		ship.addContainer(container4);
		
		new ChargeCalculator(ship);
	}
}
