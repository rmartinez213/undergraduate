import java.util.Scanner;

public class PalindromImplementation extends PalindromeInput{

	public void PalindromeMethod(){

		Scanner input = new Scanner(System.in);

		System.out.print("User Input: ");
		String palStringInput = input.nextLine();
		String palStringIgnoreCase = palStringInput.toLowerCase();
		String palString = palStringIgnoreCase.replaceAll(" ", "");

		System.out.println(palString);



		String[] AscString = new String[palStringInput.length()];
		String[] DescString = new String[palStringInput.length()];


		for(int i = 0, j = 1 ; i < palString.length() ; i++, j++){
			AscString[i] = palString.substring(i,j); 
		}

		for(int i = palString.length() , j = palString.length() - 1, k = 0 ; i > 0; i--, j--, k++){
			DescString[k] = palString.substring(j, i);
		}

		int counter = 0;
		for(int i = 0 ; i < AscString.length ;i++){
			if(DescString[i].equals(AscString[i])){
				counter++;
			}

			else if(DescString[i] != (AscString[i])){
				System.out.println("Is NOT a palindrome!");
				break;
			}
		}
		
		if (counter == palString.length()){
			System.out.println("Is a Palindrome!");
		}

	}
}
