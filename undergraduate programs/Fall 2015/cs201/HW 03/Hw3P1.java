import java.util.Scanner;
public class Hw3P1{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.print("Enter a sequence of three numbers:");
		double number1 = input.nextDouble();
		double number2 = input.nextDouble();
		double number3 = input.nextDouble();


		if ((number1 < number2) && (number2 < number3)){
			System.out.print("Strictly Increasing");
		}
		else if (((number1 <= number2) && (number2 < number3)) || ((number1 < number2) && (number2 <= number3))){
			System.out.print("Increasing");
		}
		else if ((number1 > number2) && (number2 > number3)){
			System.out.print("Strictly Decreasing");
		}
		else if (((number1 > number2) && (number2 >= number3)) || ((number1 >= number2) && (number2 > number3))){
			System.out.print("Decreasing");
		}
		else if (((number1 > number2) && (number2 < number3)) || ((number1 < number2) && (number2 > number3))){
			System.out.print("No order");
		}
		else
			System.out.print("No order");
	}
}
