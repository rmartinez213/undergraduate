import java.util.Scanner;
public class Hw2P2{
	public static void main(String[] args){
	//Create a scanner
	Scanner input = new Scanner(System.in);
	
	//Create scanner input for conversion
	System.out.print("Enter a temprature in Celsius (to convert to Fahrenheit): ");
	int celsius_number = input.nextInt();
	// Create conversion variable
	double conversion_to_Fahrenheit = (9.0 * celsius_number / 5.0) + 32.0;
	//Print conversion
	System.out.println(celsius_number + " Celsius is " + conversion_to_Fahrenheit + " Fahrenheit.");
	
	System.out.println("");
	
	//Create scanner input for conversion
	System.out.print("Enter a temprature in Fahrenheit (to convert to Celsius): ");
	int fahrenheit_number = input.nextInt();
	//Create conversion variable 
	double conversion_to_Celsius = (fahrenheit_number - 32.0) * (5.0/9.0);
	//Print the conversion
	System.out.print(fahrenheit_number + " Fahrenheit is " + conversion_to_Celsius + " Celsius.");
	}
}