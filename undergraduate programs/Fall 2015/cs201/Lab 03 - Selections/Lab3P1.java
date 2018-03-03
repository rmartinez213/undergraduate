import java.util.Scanner;
public class Lab3P1{
	public static void main(String[] args){
	
	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter three values for the sides of the triangle: ");
	double side1 = input.nextDouble();
	double side2 = input.nextDouble();
	double side3 = input.nextDouble();
	
	
	if (side1 + side2 <= side3){
		System.out.print("This is not a valid trangle.");
		System.exit(0);
	}
	
	else if  (side1 + side3 <= side2){
		System.out.print("This is not a valid triangle.");
		System.exit(0);
	}
	else if (side2 + side3 <= side1){
		System.out.print("This is not a valid triangle.");
		System.exit(0);
	}
	else{
		double s_value = (side1 +side2 + side3)/2;
		double area = Math.sqrt(s_value *(s_value - side1) * (s_value - side2) * (s_value - side3));
		System.out.println("This is a valid triangle and its area is " + area);
	}
	}
	
}