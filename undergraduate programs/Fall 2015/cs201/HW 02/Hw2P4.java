import java.util.Scanner;
public class Hw2P4{
	public static void main (String[] args){
	//Create scanner
	Scanner input = new Scanner(System.in);
	//Create scanner inputs
	System.out.print("Enter point for x1 and y1: ");
	double x1_value = input.nextDouble(), y1_value = input.nextDouble();
	System.out.print("Enter point for x2 and y2: ");
	double x2_value = input.nextDouble(), y2_value = input.nextDouble();
	
	//Create variables needed
	double x_value = (x2_value - x1_value);
	double Final_x_value = x_value * x_value;
	double y_value = (y2_value - y1_value);
	double Final_y_value = y_value * y_value;
	double distance_value = Math.sqrt(Final_x_value + Final_y_value);
	
	//print distance value
	System.out.println("The distance between point (" + x1_value + ", " + y1_value + ") and (" + x2_value + ", " + y2_value + ") is: " + distance_value);
	}
}