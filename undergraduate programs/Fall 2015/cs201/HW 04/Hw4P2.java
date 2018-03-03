public class Hw4P2{
	public static void main(String[] args){

		char Letter1 = (char)((int)(65 + (Math.random() * (90 - 65 + 1))));
		char Letter2 = (char)((int)(65 + (Math.random() * (90 - 65 + 1))));
		char Letter3 = (char)((int)(65 + (Math.random() * (90 - 65 + 1))));

		int number1 = 100 + (int)(Math.random() * (999 - 0 + 1));

		System.out.println("Your license plate number is: " + Letter1 + Letter2 + Letter3 + number1);
	}
}