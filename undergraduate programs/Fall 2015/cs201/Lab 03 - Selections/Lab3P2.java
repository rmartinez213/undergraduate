import java.util.Scanner;
public class Lab3P2{
	public static void main(String[] args){
	
	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter a, b, c: ");
	double a = input.nextDouble();
	double b = input.nextDouble();
	double c = input.nextDouble();
	
	double discriminant = (Math.pow(b,2) - (4 * a * c));
	
	
	if (discriminant > 0){
		double first_root = (-b + Math.sqrt(discriminant)) / (2 * a);
		double second_root = (-b - Math.sqrt(discriminant)) / (2 * a);
		System.out.println("The roots are " + first_root + " and " + second_root);
	}
	else if (discriminant == 0){
		double first_root = (-b + Math.sqrt(discriminant)) / (2 * a);
		System.out.println("The root is " + first_root);
	}
	else if (discriminant < 0) {
		System.out.println("The equation has no real roots");
	}
	}
}