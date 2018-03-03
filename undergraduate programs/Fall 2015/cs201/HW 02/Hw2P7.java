import java.util.Scanner;
public class Hw2P7{
	public static void main (String[] args){
	//Create Scanner
	Scanner input = new Scanner(System.in);
	//Create Scanner inputs
	//Tickets sold
	System.out.print("How many adult tickets were sold? ");
	int adults_sold = input.nextInt();
	System.out.print("How many children tickets were sold? ");
	int children_sold = input.nextInt();
	System.out.println("");
	
	//Child Price
	System.out.print("Enter price per adult ticket: ");
	double adult_ticket_price = input.nextDouble();
	System.out.print("Enter price per child ticket: ");
	double child_ticket_price = input.nextDouble();
	System.out.println("");
	System.out.print("Enter movie company percentage: ");
	double movie_percentage = input.nextDouble();
	System.out.println("");
	
	//Do calculations
	double movie_net_computation = 1.0 - movie_percentage;
	
	double adult_gross = adults_sold * adult_ticket_price;
	double adult_net = adult_gross * movie_net_computation;
	
	double child_gross = children_sold * child_ticket_price;
	double child_net = child_gross * movie_net_computation;
	
	double total_gross = adult_gross + child_gross;
	double total_net = total_gross * movie_net_computation;
	
	//Begin printing out the sales report
	System.out.println("Sales Report:");
	System.out.println("===========================================");
	System.out.println("");
	System.out.println("Gross Revenue(Adult): $" + adult_gross);
	System.out.println("Net Revenue(Adult): $"+ adult_net);
	System.out.println("");
	System.out.println("Gross Revenue(Child): $" + child_gross);
	System.out.println("Net Revenue(Child): $"+ child_net);
	System.out.println("");
	System.out.println("Total Gross Revenue: $" + total_gross);
	System.out.println("Total Net Revenue: $" + total_net);
	//Create computations
	}
}