import java.util.Scanner;
public class Hw4P7 {
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);	

		System.out.print("Enter the date of the check:");
		String date = input.nextLine();

		System.out.print("Who is the check for?");
		String name = input.nextLine();

		System.out.print("What is the amount of the check?");
		double amount = input.nextDouble();

		//decimal


		if ((amount > 5000) || (amount < 0)){
			System.out.println("Invalid Input");
			System.exit(0);
		}

		//Determine Variable Placement
		int integer_1 = (int)(amount/1000);
		int integer_2 = (int)(amount/100)%10;
		int integer_3 = (int)(amount%100)/10;
		int integer_4 = (int)(amount%10);
		int integer_5 = (int)(integer_4 + (integer_3 * 10));

		//Print Information Needed
		System.out.println("\t\t\t\t\t\t\t Date: " + date);
		System.out.println("");
		System.out.printf("Pay to order of: %s \t\t\t     $%4.2f \n", name, amount);
		System.out.println("");


		if (amount <= 5000){

			switch(integer_1){
			case 1: System.out.print("One Thousand ");
			break;
			case 2: System.out.print("Two Thousand ");
			break;
			case 3: System.out.print("Three Thousand ");
			break;
			case 4: System.out.print("Four Thousand ");
			break;
			case 5: System.out.print("Five Thousand ");
			break;
			}

			switch(integer_2){
			case 1: System.out.print("One Hundred ");
			break;
			case 2: System.out.print("Two Hundred ");
			break;
			case 3: System.out.print("Three Hundred ");
			break;
			case 4: System.out.print("Four Hundred ");
			break;
			case 5: System.out.print("Five Hundred ");
			break;
			case 6: System.out.print("Six Hundred ");
			break;
			case 7: System.out.print("Seven Hundred ");
			break;
			case 8: System.out.print("Eight Hundred ");
			break;
			case 9: System.out.print("Nine Hundred ");
			break;
			}
			switch(integer_3){
			case 2: System.out.print("Twenty ");
			break;
			case 3: System.out.print("Thirty ");
			break;
			case 4: System.out.print("Fourty ");
			break;
			case 5: System.out.print("Fifty ");
			break;
			case 6: System.out.print("Sixty ");
			break;
			case 7: System.out.print("Seventy ");
			break;
			case 8: System.out.print("Eighty ");
			break;
			case 9: System.out.print("Ninety ");
			break;
			}


			//Print Cents
		}

		if ((integer_5 >= 10) && (integer_5 < 20)){
			switch(integer_5){
			case 10: System.out.print("Ten");
			break;
			case 11: System.out.print("Eleven");
			break;
			case 12: System.out.print("Twelve");
			break;
			case 13: System.out.print("Thirteen");
			break;
			case 14: System.out.print("Fourteen");
			break;
			case 15: System.out.print("Fifteen");
			break;
			case 16: System.out.print("Sixteen");
			break;
			case 17: System.out.print("Seventeen");
			break;
			case 18: System.out.print("Eighteen");
			break;
			case 19: System.out.print("Nineteen");
			break;
			}
		}

		else if((integer_5 > 20)){
			switch(integer_4){
			case 1: System.out.print("One");
			break;
			case 2: System.out.print("Two");
			break;
			case 3: System.out.print("Three");
			break;
			case 4: System.out.print("Four");
			break;
			case 5: System.out.print("Five");
			break;
			case 6: System.out.print("Six");
			break;
			case 7: System.out.print("Seven");
			break;
			case 8: System.out.print("Eight");
			break;
			case 9: System.out.print("Nine");
			break;
			}
		}
		int cents = (int)((amount %1) * 100);
		System.out.print(" and " + cents + " cents");


	}		
}