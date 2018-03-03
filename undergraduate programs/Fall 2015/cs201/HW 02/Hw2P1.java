
import java.util.Scanner;
public class Hw2P1 {
	public static void main (String[] args){
	Scanner input = new Scanner(System.in);
	// Create a scanner imput
	System.out.print("Enter a number: ");
	int first_number = input.nextInt();
	
	System.out.print("Enter the second number: ");
	int second_number = input.nextInt();
	
	//Declare variables for number execution
	int number_sum = first_number + second_number;
	int number_subtract = first_number - second_number;
	int number_product = first_number * second_number;
	double number_average = ((double)first_number + second_number) / 2;
	int number_max = Math.max(first_number,second_number);
	int number_min = Math.min(first_number,second_number);
	
	//Print the values
	System.out.println("Sum: \t\t" + number_sum);
	System.out.println("Difference: \t" + number_subtract);
	System.out.println("Product: \t" + number_product);
	System.out.println("Average: \t" + number_average);
	System.out.println("Maximum: \t" + number_max);
	System.out.println("Minimum: \t" + number_min);
	}	
}
