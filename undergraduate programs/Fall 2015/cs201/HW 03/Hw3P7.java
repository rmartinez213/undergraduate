import java.util.Scanner;
public class Hw3P7{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.print("Enter the starting time of the call: ");
		double start = input.nextDouble();

		System.out.print("Enter the length of the call: ");
		double length = input.nextDouble();
		
		
		if ((length < 0 ) ||(start < 0)){
			System.out.println("Does not accept negative values.");
		}
		else if (((start >= 0.0) && (start <= 6.59)) && (length > 0)){
			double first = length * 0.12;
			System.out.print("The total cost is: " + first);
		}
		else if (((start >= 7.00) && (start <= 19.00)) && (length  > 0)){
			double second = length * 0.55;
			System.out.print("The total cost is: " + second);
		}
		else if (((start >= 19.01) && (start <= 23.59)) && (length > 0)){
			double third = length * 0.35;
			System.out.print("The total cost is: " + third);
		}
		else if (start > 23.59){
			System.out.println("Can't accept numbers above 23.59 at all times.");
		}
	}
}