import java.util.Scanner;
public class Hw2P3{
	public static void main (String[] args){
	//Create Scanner
	Scanner input = new Scanner(System.in);
	//Create Scanner input
	System.out.print("Enter the length, width, height of a pyramid object: ");
	double length_value = input.nextDouble(), width_value = input.nextDouble(), height_value = input.nextDouble();
	//Create variables needed
	double area_value = length_value * width_value;
	double volume_value = (1.0/3.0) * (area_value * height_value);
	//Print Commands
	System.out.println("The area is: " + area_value);
	System.out.println("The volume is: " + volume_value);
	}
}