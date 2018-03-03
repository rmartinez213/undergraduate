import java.util.Scanner;
public class Lab1P2{
	public static void main(String[] args){
	//Create Scanner
	Scanner input = new Scanner(System.in);
	
	//Create Scanner input
	System.out.print("Enter the monthly savings amount: ");
	double savings = input.nextDouble();
	
	System.out.print("Enter the annual interest rate: ");
	double interest_rate = input.nextDouble();
	
	//Interest computation
	double interest_value_rate = (interest_rate/12);
	double interest_final = 1 + interest_value_rate;
	//Month computation
	double first_month = savings * interest_final;
	double second_month = (savings + first_month) * interest_final;
	double third_month = (savings + second_month) * interest_final;
	double fourth_month = (savings + third_month) * interest_final;
	double fifth_month = (savings + fourth_month) * interest_final;
	double sixth_month = (savings + fifth_month) * interest_final;
	System.out.println(sixth_month);
	}
}