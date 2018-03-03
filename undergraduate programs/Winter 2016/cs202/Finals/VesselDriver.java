

public class VesselDriver {

	public static void main(String[] args) {

		System.out.println("-----Glass Content-----");
		Glass glass = new Glass(0);
		glass.getCurrentContentsInCC();

		double capacity = glass.getCapacityInCC();
		double pour = glass.pourIn(capacity); 
		glass.pourOut(pour);
		glass.getCurrentContentsInCC();

		System.out.println();
		System.out.println();
		System.out.println("-----Cup Content-----");

		Cup cup = new Cup(0);
		cup.getCurrentContentsInCC();

		double cupcapacity = cup.getCapacityInCC();
		double cuppour = cup.pourIn(cupcapacity); 
		cup.pourOut(cuppour);
		cup.getCurrentContentsInCC();

	}

}
