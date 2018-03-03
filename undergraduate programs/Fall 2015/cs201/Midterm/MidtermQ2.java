import java.util.Scanner;
public class MidtermQ2 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		//VARIABLES DO NOT MATH WITH WHAT IT IS ASKING THE USER
		//Still prints fine though

		System.out.print("How many rows?: ");
		int column = input.nextInt();
		System.out.print("How many columns?: ");
		int row = input.nextInt();

		for(int x = 1 ; x <= row ; x++){
			System.out.print("x^" + x + "\t");
		}

		System.out.println();

		for(int x = 1 ; x <= column ; x++){
			for(int y = 1, power = 1 ; y <= row ; y++, power++){
				System.out.print((int)Math.pow(x, power) + "\t");
			}
			System.out.println();
		}
	}
}