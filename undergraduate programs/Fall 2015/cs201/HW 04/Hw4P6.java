import java.util.Scanner;
public class Hw4P6 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter employee's name: ");
		String employee = input.nextLine();

		System.out.print("Enter number of hours worked in a week:");
		double weekly_worked = input.nextDouble();

		System.out.print("Enter your hourly pay rate:");
		double hourly_wage = input.nextDouble();

		System.out.print("Enter federal tax withholding rate: ");
		double federal_tax = input.nextDouble();

		System.out.print("Enter state tax withholding rate: ");
		double state_tax = input.nextDouble();

		if ((weekly_worked < 0 || hourly_wage < 0) || ((federal_tax < 0) || state_tax < 0)){
			System.out.println("Does not accept negative values for any of the inputs.");
		}

		else if ( weekly_worked > 40 ){
			double regular_pay = hourly_wage * 40;
			double overtime_pay = (weekly_worked - 40) * (hourly_wage * 1.5);
			double total_pay = regular_pay + overtime_pay;
			double federal_percentage = (federal_tax * 100);
			double federal_final = total_pay * federal_tax;
			double state_percentage = (state_tax * 100);
			double state_final = (total_pay * state_tax);
			double total_deduction = (state_final + federal_final);
			double net_pay = total_pay - total_deduction;
			System.out.println("Employee Name: " + employee);
			System.out.printf("Hours Worked: %2.0f \r", weekly_worked);
			System.out.printf("Pay Rate: $%3.2f \r", hourly_wage);
			System.out.printf("Regular Pay: $%6.2f \r", regular_pay);
			System.out.printf("Overtime Pay: $%6.2f \r" , overtime_pay);
			System.out.printf("Gross Pay: $%6.2f \r", total_pay);
			System.out.println("Deductions:");
			System.out.printf("\t Federal Withholding (%2.1f%%): $%5.2f \r", federal_percentage, federal_final);
			System.out.printf("\t State Withholding (%2.1f%%): $%5.2f \r", state_percentage, state_final);
			System.out.printf("\t Total Deduction: $%5.2f \r", total_deduction);
			System.out.printf("Net Pay: $%6.2f \r", net_pay);
		}

		else if (weekly_worked < 40){
			double regular_pay = hourly_wage * weekly_worked;
			double total_pay = regular_pay;
			double federal_percentage = (federal_tax * 100);
			double federal_final = total_pay * federal_tax;
			double state_percentage = (state_tax * 100);
			double state_final = (total_pay * state_tax);
			double total_deduction = (state_final + federal_final);
			double net_pay = total_pay - total_deduction;

			System.out.println("Employee Name: " + employee);
			System.out.printf("Hours Worked: %2.0f \r", weekly_worked);
			System.out.printf("Pay Rate: $%3.2f \r", hourly_wage);
			System.out.printf("Regular Pay: $%6.2f \r", regular_pay);
			System.out.printf("Gross Pay: $%6.2f \r", total_pay);
			System.out.println("Deductions:");
			System.out.printf("\t Federal Withholding (%2.1f%%): $%5.2f \r", federal_percentage, federal_final);
			System.out.printf("\t State Withholding (%2.1f%%): $%5.2f \r", state_percentage, state_final);
			System.out.printf("\t Total Deduction: $%5.2f \r", total_deduction);
			System.out.printf("Net Pay: $%6.2f \r", net_pay);
		}
	}

}
