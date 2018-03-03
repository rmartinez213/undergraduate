import java.util.Scanner;
public class Hw5P1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Input an intenger: ");
		int a = input.nextInt();

		System.out.print("Input a second integer: ");
		int b = input.nextInt();
		
		int z = a;
		
		System.out.println();

		// Addition the even variable
		int sum = 0;
		for (int i = a; i <= b; i++){
			if(i % 2 == 0){
				sum = sum + i;
			}
		}
		System.out.println("The sum of all even variables in between (inclusive): " + sum);

		//Multiplying the variable in between

		int multiply = 1;
		for (int i = a ; i <= b ; i++){
			multiply = multiply * i;
		}
		System.out.println("The multiplication of all variables in between (inclusive): " + multiply);

		//Sum the squares
		int square = 0;
		for (int i = a; i <= b; i++){
			square += (int)Math.pow(a, 2);
			a++;
		}
		System.out.println("The sum of all squared variables in between (inclusive): " + square);

		//All Powers
		System.out.print("The squared list of numbers are: ");
		while (z <= b){
			System.out.print("2^" + z + " " );
			z++;
		}
	}
}
