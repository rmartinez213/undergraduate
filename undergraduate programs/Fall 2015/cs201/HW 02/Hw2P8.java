import java.util.Scanner;
public class Hw2P8{
	public static void main(String[] args){
	//Create Scanner
	Scanner input = new Scanner(System.in);	
	
	//Create Scanner input
	System.out.print("What is the subtotal of the bill? ");
	double subtotal = input.nextDouble();
	System.out.print("How much tax does state currently charge? ");
	double tax = input.nextDouble();
	System.out.print("Enter the perecentage of tip you usually leave: ");
	double tip = input.nextDouble();
	System.out.print("How many people are dining in your party? ");
	int party = input.nextInt();
	
	//Value and Calculations
	double tax_final = tax * subtotal;
	double tip_final = ((subtotal + tax_final) * tip);
	double total = subtotal + tax_final + tip_final;
	double party_value = total / party;
	
	//print results needed
	System.out.println("Subtotal: $" + subtotal);
	System.out.println("Tax: $" + tax_final);
	System.out.println("Tip: $" + tip_final);
	System.out.println("Total: $" + total);
	System.out.println("Each Person Owes: $" + party_value);
	}
}