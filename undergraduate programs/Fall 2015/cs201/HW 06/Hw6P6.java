import java.util.Scanner;
public class Hw6P6 {

	public static void main(String[] args) {

		getPrint();
	}

	public static void getPrint(){
		Scanner input = new Scanner(System.in);

		while (true){
			int dice1 = 1 + (int)(Math.random() * (6 - 1 + 1));
			int dice2 = 1 + (int)(Math.random() * (6 - 1 + 1));
			int res = dice1 + dice2;
			System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + res);

			if(res == 5 || res == 10){
				System.out.println("You Win!");
			}
			else if(res == 4 || res == 7 || res == 12){
				System.out.println("You Lose!");
			}
			else if (res == 2 || res == 3 || res == 6 || res == 8 || res == 9 || res == 11){ 
				System.out.println("Point is " + res);

				getPoint(res);
			}
			System.out.println();

			getEnding();
		}
	}
	
	public static void getPoint(int res){
		while(true){
			int dice3 = 1 + (int)(Math.random() * (6 - 1 + 1));
			int dice4 = 1 + (int)(Math.random() * (6 - 1 + 1));
			int res2 = dice3 + dice4;
			if(res == res2){
				System.out.println("You rolled " + dice3 + " + " + dice4 + " = " + res2);
				System.out.println("You win!");
				break;
			}
			else if(res2 == 7){
				System.out.println("You rolled " + dice3 + " + " + dice4 + " = " +  res2);
				System.out.print("You Lose!");
				break;
			}
		}
	}

	public static void getEnding(){
		Scanner input = new Scanner(System.in);
		System.out.print("Would you like to pay again ( 0 FOR YES! / 1 FOR NO!) ? ");
		int PlayAgain = input.nextInt();

		if(PlayAgain == 0){
			System.out.println();
		}
		else{
			System.out.println("Game will now exit!");
			System.out.println("Thanks for playing!");
			System.exit(1);
		}
	}

}
