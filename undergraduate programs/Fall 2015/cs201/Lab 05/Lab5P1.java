import java.util.Scanner;
public class Lab5P1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter two integers: ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int sum = 0;
		System.out.println("Combinations: ");
		
		
		for (int num = number1; num <= number2; num++){
			 for (int num2 = number1; num2 <= number2; num2++) {
				 System.out.print(num + " " + num2);
				 System.out.println();
				 sum++;
			 }
			}
		System.out.print("Total combinations: " + sum);
	}

}
