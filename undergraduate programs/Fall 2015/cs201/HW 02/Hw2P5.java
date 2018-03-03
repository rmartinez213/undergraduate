import java.util.Scanner;
public class Hw2P5{
	public static void main (String[] args){
	
	//Create a Scanner
	Scanner input = new Scanner (System.in);
	//Create inputs for Scanner
	System.out.print("Enter a temprature in Fahrenheit between -58F and 41F: ");
	double temperature_value = input.nextDouble();
	System.out.print("Enter a wind speed greater than or equal to 2 in miles per hour: ");
	double speed_value = input.nextDouble();
	
	//Create variables/computation
	double speed_value_squared = Math.pow(speed_value,0.16);
	double wind_chill_temprature = 35.74 + (0.6215 * temperature_value) - 35.75 * speed_value_squared + 0.4275 * temperature_value * speed_value_squared;
	
	//Print results
	System.out.print("The wind chill temprature is " + wind_chill_temprature);
	}
}