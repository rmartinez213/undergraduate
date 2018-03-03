import java.util.Scanner;
public class Lab1P1{
	public static void main(String[] args){
	//Create Scanner for console
	Scanner input = new Scanner(System.in);
	
	//Create output for Scanner
	System.out.print("Enter a number from 0 to 1000: ");
	int number_value = input.nextInt();
	//Create variables for  final output
	int value1 = (number_value/100);
	int value2 = (number_value%10);
	int value3 = (number_value%100/10);
	int final_value = value1 + value2 + value3;
	//Display result
	System.out.println("Your value is: " + final_value);
	}
}