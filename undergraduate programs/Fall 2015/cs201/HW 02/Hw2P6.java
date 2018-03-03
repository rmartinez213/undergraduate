import java.util.Scanner;
public class Hw2P6{
	public static void main(String[] args){
	//Create Scanner
	Scanner input = new Scanner(System.in);
	//Create Scanner input 
	System.out.print("How many class A tickets were sold? ");
	int a_tickets = input.nextInt();
	System.out.print("How many class B tickets were sold? ");
	int b_tickets = input.nextInt();
	System.out.print("How many class C tickets were sold? ");
	int c_tickets = input.nextInt();
	
	//Create math operation variables
	double a_tickets_revenue = 15.0 * a_tickets;
	double b_tickets_revenue = 12.0 * b_tickets;
	double c_tickets_revenue = 9.0 * c_tickets;
	double total_tickets_revenue = a_tickets_revenue + b_tickets_revenue + c_tickets_revenue;
	
	//print final sales
	System.out.println("");
	System.out.println("Total income sales for tickets A: $" + a_tickets_revenue);
	System.out.println("Total income sales for tickets B: $" + b_tickets_revenue);
	System.out.println("Total income sales for tickets C: $" + c_tickets_revenue);
	
	System.out.println ("Total income of all sales: $" + total_tickets_revenue);
	}
}