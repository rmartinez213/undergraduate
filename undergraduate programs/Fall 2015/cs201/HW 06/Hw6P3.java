import java.util.Scanner;
public class Hw6P3 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter a password (11 characters long, 2 digits, 5 letters, 2 uppercase letters, 3 non-alphanumerical numbers):");
		String user = input.next();


		getStrings(user);
		getDigit(user);
		getLetter(user);
		getUpperCase(user);
		getSymbols(user);
	}

	public static int getStrings(String user){
		int length = user.length();
		if(length >= 11){
			System.out.println("Amount needed Valid!");
		}
		else{
			System.out.println("Amount of characters Invalid!");
		}
		return length;
	}

	public static void getDigit(String user){
		int length = user.length();
		int count = 0;
		for(int i = 0 ; i < length; i++){

			if(Character.isDigit(user.charAt(i)) == true){ 
				count += 1;
			}
		}
		if(count >= 2){
			System.out.println("Amount of digits is Valid!");
		}
		else if(count < 2){
			System.out.println("Amount of digits is Invalid!");
		}
	}

	public static void getLetter(String user){
		int length = user.length();

		int count = 0;
		for(int i = 0 ; i < length; i++){

			if(Character.isLetter(user.charAt(i)) == true){ 
				count += 1;
			}
		}
		if(count >= 5){
			System.out.println("Amount of letters is Valid!");
		}
		else if(count < 5){
			System.out.println("Amount of letter is Invalid!");
		}
	}

	public static void getUpperCase(String user){
		int length = user.length();
		int count = 0;
		for(int i = 0 ; i < length; i++){

			if(Character.isUpperCase(user.charAt(i)) == true){ 
				count += 1;
			}
		}
		if(count >= 2){
			System.out.println("Amount of Upper Case Letters is Valid!");
		}
		else if(count < 2){
			System.out.println("Amount of Upper Case Letters is Invalid!");
		}
	}

	public static void getSymbols(String user){
		int length = user.length();
		int count = 0;
		for(int i = 0 ; i < length ; i++){
			if(Character.isLetterOrDigit(user.charAt(i)) != true){
				count += 1;
			}

		}
		if(count >= 3){
			System.out.println("Amount of Special Characters is Valid!");
		}
		else if(count < 3){
			System.out.println("Amount of Special Characters is Invalid!");
		}
	}
}


