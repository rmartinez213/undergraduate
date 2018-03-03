package Lab3;
import java.util.Scanner;

public class OverloadingExcercies {
		
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an input for NUMBERS: ");
		int numbers = input.nextInt();
		input.nextLine();
		
		System.out.print("Enter an input for a STRING: ");
		String word = input.nextLine();

		
		
		DisplayOverloading object = new DisplayOverloading();
		object.reverse(numbers);
		object.reverse(word);
		
		System.out.println(object.reverse(numbers));
		//System.out.println(object.reverse(word));
	}
	

}
