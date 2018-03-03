import java.util.Scanner;
public class Hw3P3{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.print("Enter your hourly wage:");
		double hourly_wage = input.nextDouble();
		System.out.print("Enter number of hours worked in the past week:");
		double weekly_worked = input.nextDouble();

		if ((weekly_worked < 0 || hourly_wage < 0)){
			System.out.println("Do not accept negative values for any of the inputs.");
		}

		else if ( weekly_worked > 40 ){
			double regular_pay = hourly_wage * 40;
			double overtime_pay = (weekly_worked - 40) * (hourly_wage * 1.5);
			double total_pay = regular_pay + overtime_pay;
			System.out.println("Regular Pay:" + regular_pay);
			System.out.println("Overtime Pay:" + overtime_pay);
			System.out.print("Total Pay: " + total_pay);
		}

		else if (weekly_worked < 40){
			double regular_pay = hourly_wage * weekly_worked;
			double total_pay = regular_pay;
			System.out.println("Regular Pay:" + regular_pay);
			System.out.print("Total Pay: " + total_pay);
		}
	}
}