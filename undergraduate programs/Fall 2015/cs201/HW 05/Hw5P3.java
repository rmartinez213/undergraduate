import java.util.Scanner;
public class Hw5P3 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String user = input.nextLine();
		//String vowels = 
		String uppercase = "";
		String vowel = "";
		int count_vowel = 0;
		int count_consonants = 0;
		String N_vowel = "";
		for(int i = 0 ; i < user.length(); i++){
			if(Character.isUpperCase(user.charAt(i))) {
				char j = user.charAt(i);
				uppercase = uppercase + j + "  ";
			}

			char k = user.charAt(i);
			if((k != 'a') && (k != 'e') && (k != 'i') && (k != 'o') && (k != 'u') && (k != 'A') && (k != 'E') && (k != 'I') && (k != 'O') && (k != 'U')){
				vowel = vowel + k ;
			}
			else{
				vowel = vowel + "_" ;	
			}
			
			if((k == 'a') || (k == 'e') || (k == 'i') || (k == 'o') || (k == 'u') || (k == 'A') || (k == 'E') || (k == 'I') || (k == 'O') || (k == 'U')){
				count_vowel = (count_vowel + 1);
			}
			
			if((k != 'a') && (k != 'e') && (k != 'i') && (k != 'o') && (k != 'u') && (k != 'A') && (k != 'E') && (k != 'I') && (k != 'O') && (k != 'U') && k != ' '){
				count_consonants = (count_consonants + 1);
			}
			if((k == 'a') || (k == 'e') || (k == 'i') || (k == 'o') || (k == 'u') || (k == 'A') || (k == 'E') || (k == 'I') || (k == 'O') || (k == 'U')){
				int position_vowel = user.indexOf(k, i);
				N_vowel = N_vowel + " " + position_vowel;
			}
		}
		System.out.println("Uppercase Letters: " + uppercase);
		System.out.println("Vowels Replaced: " + vowel);
		System.out.println("Nunber of Vowels: " + count_vowel);
		System.out.println("Nunber of Consonants: " + count_consonants);
		System.out.println("Position of Vowels: " + N_vowel);
}
}
