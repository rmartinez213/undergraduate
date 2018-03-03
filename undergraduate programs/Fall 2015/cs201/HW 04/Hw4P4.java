import java.util.Scanner;
public class Hw4P4{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		//Ask user for social and input the scanner
		System.out.print("Enter a social security number: ");
		String social_security = input.nextLine();




		if ((social_security.length() != 11)){
			System.out.print(social_security + " is not a valid number.");
			System.exit(0);
		}

		char letter0 = social_security.charAt(0);
		char letter1 = social_security.charAt(1);
		char letter2 = social_security.charAt(2);
		char letter3 = social_security.charAt(3);
		char letter4 = social_security.charAt(4);
		char letter5 = social_security.charAt(5);
		char letter6 = social_security.charAt(6);
		char letter7 = social_security.charAt(7);
		char letter8 = social_security.charAt(8);
		char letter9 = social_security.charAt(9);
		char letter10 = social_security.charAt(10);


		if (( ( (Character.isDigit(letter0)) && (Character.isDigit(letter1) && (Character.isDigit(letter2))) && (((letter3 == '-')) && (Character.isDigit(letter4))) &&
				((Character.isDigit(letter5) && ((letter6 == '-')))) && ((Character.isDigit(letter7) && (Character.isDigit(letter8)))) && Character.isDigit(letter9)) && Character.isDigit(letter10))) {
			System.out.print(social_security + " is a valid number.");

		}

		else{
			System.out.print(social_security + " is not a valid number.");
		}



	}
}