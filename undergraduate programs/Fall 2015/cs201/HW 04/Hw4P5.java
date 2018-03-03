import java.util.Scanner;
public class Hw4P5 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter phone number: ");
		String number = input.nextLine();

		int number_info = number.length();



		if ((number.length() != 10)){
			System.out.println("Wrong Input");
			System.exit(0);
		}

		char d = number.charAt(0);
		char d2 = number.charAt(1);
		char d3 = number.charAt(2);
		char d4 = number.charAt(3);
		char d5 = number.charAt(4);
		char d6 = number.charAt(5);
		char d7 = number.charAt(6);
		char d8 = number.charAt(7);
		char d9 = number.charAt(8);
		char d10 = number.charAt(9);

		if (( number.length() == 10) && (Character.isDigit(d)) && 
				((Character.isDigit(d2) && (Character.isDigit(d3)))) && 
				((Character.isDigit(d4) && (Character.isDigit(d5)))) && 
				((Character.isDigit(d6) && (Character.isDigit(d7)))) && 
				((Character.isDigit(d8) && (Character.isDigit(d9)))) &&  
				(Character.isDigit(d10)))  {

			String format_number = number.substring(0,3);
			String format_number2 = number.substring(3,6);
			String format_number3 = number.substring(6);

			System.out.println("(" + format_number + ")" + format_number2 + "-" + format_number3);

		}
		else{
			System.out.print("Wrong Input");	
			System.exit(0);
		}

	}

}
