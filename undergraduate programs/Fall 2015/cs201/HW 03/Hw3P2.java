import java.util.Scanner;
public class Hw3P2{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		//Create Value Inputs For User
		System.out.print("Enter A value:");
		double a_value = input.nextDouble();

		System.out.print("Enter B value:");
		double b_value = input.nextDouble();

		System.out.print("Enter C value:");
		double c_value = input.nextDouble();

		System.out.print("Enter D value:");
		double d_value = input.nextDouble();

		System.out.print("Enter E value:");
		double e_value = input.nextDouble();

		System.out.print("Enter F value:");
		double f_value = input.nextDouble();
		//Create mathatic equation/solution
		if ((a_value * d_value) - (b_value * c_value) != 0){

			double x_value = ((e_value * d_value) - (b_value * f_value)) / ((a_value * d_value) - (b_value * c_value));
			System.out.println("The x value is: " + x_value);

			double y_value = ((a_value * f_value) - (e_value * c_value)) / ((a_value * d_value) - (b_value * c_value));
			System.out.print("The y value is: " + y_value);

		}
		else 
			System.out.print("The equation has no solution.");
	}
}