import java.util.Scanner;
public class Lab4P1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a word: ");
		String word = input.nextLine();
		
		String first_letter = word.substring(0,1);
		
		
		String no_letter = word.substring(1);
		
		
		String ay = "ay" ;
				
		
		
		System.out.println(no_letter + first_letter + ay);
	}

}
