import java.util.Scanner;
public class Hw3P4{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.print("Enter a number(0, 1, 2 ONLY):" );
		int user = input.nextInt();
		int ai = 0 + (int)(Math.random() * (3 - 1 + 1));


		if(user < 0 || user > 2) {
			System.out.println("Wrong input.");
		}

		else {
			if (ai == 0){
				System.out.println("AI chose Rock");
				System.out.println("");
				System.out.println("    _______");
				System.out.println("---'   ____)");
				System.out.println("      (_____)");
				System.out.println("      (_____)");
				System.out.println("      (____)");
				System.out.println("---.__(___)");
				System.out.println("");
			}
			else if (ai == 1){
				System.out.println("AI chose Paper");
				System.out.println("");
				System.out.println("    _______");
				System.out.println("---'   ____)____");
				System.out.println("          ______)");
				System.out.println("          _______)");
				System.out.println("         _______)");
				System.out.println("---.__________)");
				System.out.println("");
			}
			else if (ai == 2){
				System.out.println("AI chose Scissors");
				System.out.println("");
				System.out.println("    _______");
				System.out.println("---'   ____)____");
				System.out.println("          ______)");
				System.out.println("       __________)");
				System.out.println("      (____)");
				System.out.println("---.__(___)");
				System.out.println("");

			}

			if (user == 0){
				System.out.println("You chose Rock");
				System.out.println("");
				System.out.println("    _______");
				System.out.println("---'   ____)");
				System.out.println("      (_____)");
				System.out.println("      (_____)");
				System.out.println("      (____)");
				System.out.println("---.__(___)");
				System.out.println("");
			}
			else if (user == 1){
				System.out.println("You chose Paper");
				System.out.println("");
				System.out.println("    _______");
				System.out.println("---'   ____)____");
				System.out.println("          ______)");
				System.out.println("          _______)");
				System.out.println("         _______)");
				System.out.println("---.__________)");
				System.out.println("");
			}
			else if (user == 2){
				System.out.println("You chose Scissors");
				System.out.println("");
				System.out.println("    _______");
				System.out.println("---'   ____)____");
				System.out.println("          ______)");
				System.out.println("       __________)");
				System.out.println("      (____)");
				System.out.println("---.__(___)");
				System.out.println("");
			}


			if ( user == ai) {
				System.out.println("Its a draw!");
			}
			else if (user == ai) {
				System.out.println("Its a draw!");
			}
			else if (user == ai) {
				System.out.println("Its a draw!");
			}

			if ((user == 0) && (ai == 1)){
				System.out.println("AI wins!");
			}
			else if((user == 0 ) && (ai == 2)){
				System.out.print("Player wins!"); 
			}

			else if ((user == 1) && (ai == 0)){
				System.out.println("Player wins!");
			}
			else if ((user == 1) && (ai == 2)){
				System.out.println("AI wins!");
			}
			else if ((user == 2) && (ai == 0)){
				System.out.println("AI wins!");
			}
			else if ((user == 2) && (ai == 1)){
				System.out.println("Player wins!");
			}
		}
	}
}