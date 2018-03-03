import java.util.Scanner;
public class Lab4P2 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter two characters: ");
		String user_input = input.nextLine();
		
		String character = user_input.substring(0,1);
			
		String number = user_input.substring(1,2);
		
		int character_digit = character.charAt(0);
		
		int number_digit = user_input.charAt(1);
		
		
		//Mathematics
		
		if ((character_digit == 77) && (number_digit == 49)){
			System.out.print("Mathematics Freshman");
		}
		else if((character_digit == 77) && (number_digit == 50)){
			System.out.print("Mathematics Sophmore");
		}
		else if((character_digit == 77) && (number_digit == 51)){
			System.out.print("Mathematics Junior");
		}
		else if((character_digit == 77) && (number_digit == 52)){
			System.out.print("Mathematics Senior");
		}
		
			//Computer Scence
		
		else if ((character_digit == 67) && (number_digit == 49)){
			System.out.print("Computer Science Freshman");
		}
		else if((character_digit == 67) && (number_digit == 50)){
			System.out.print("Computer Science Sophmore");
		}
		else if((character_digit == 67) && (number_digit == 51)){
			System.out.print("Computer Science Junior");
		}
		else if((character_digit == 67) && (number_digit == 52)){
			System.out.print("Computer Science Senior");
		}
		
		//Information Technology
		
		else if ((character_digit == 73) && (number_digit == 49)){
			System.out.print("Technology Freshman");
		}
		else if((character_digit == 73) && (number_digit == 50)){
			System.out.print("Technology Sophmore");
		}
		else if((character_digit == 73) && (number_digit == 51)){
			System.out.print("Technology Junior");
		}
		else if((character_digit == 73) && (number_digit == 52)){
			System.out.print("Technology Senior");
		}
		else{
		System.out.print("Invalid Characters!");
		System.exit(1);
		}
	
	}
		
		
		
}
