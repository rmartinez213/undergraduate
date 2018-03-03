import java.util.Scanner;
public class Hw3P8{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.print("Enter a 5 didgit number: ");
		int user = input.nextInt();
		int first_number = (user / 10000);
		int second_number = (user / 1000 % 10);
		int third_number = (user % 1000 / 100);
		int fourth_number = (user / 10 % 10);
		int fifth_number = user % 10;


		if (user < 9999) {
			System.out.println(user + " is not a 5 digit number!");
		}
		else if ((first_number == fifth_number) && (second_number == fourth_number)){
			System.out.println(user + " is a palindrome!");
		}
		else if ((second_number == third_number) &&  (third_number == fourth_number)){
			System.out.println(user + " is a palindrome!");
		}
		else if (((first_number == second_number) && (second_number == third_number)) && ((third_number == fourth_number) && (fourth_number == fifth_number))){
			System.out.println(user + " is a palindrome!");
		}
		else {
			System.out.println(user + " is not a palindrome!");
		}

	}

}