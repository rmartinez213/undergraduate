import java.util.Scanner;
public class Hw7P4 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.print("Enter a 10 digit lottery number: ");

		long user = input.nextLong();
		int[] UserArray = getArray(user);
		int[] RandomArray = random();

		value(RandomArray, UserArray);
	}

	public static int[] random(){
		int[] lottery = new int[10];

		for(int x = 0; x < 10; x++){
			lottery[x] = 0 + (int)(Math.random() * (9 - 0 + 1));

		}
		return lottery;
	}

	public static void value(int[] random,int[] createRandArr){

		System.out.print("Winning Number: \t");
		for(int x = 0; x < 10; x++){
			System.out.print(random[x] + " ");
		}
		System.out.println();
		System.out.print("User Guess: \t\t");
		int count = 0;
		for(int x = 0 ; x < 10 ; x++){
			System.out.print(createRandArr[x] + " ");
			if(random [x] == createRandArr[x]){
				count++;
			}
		}
		System.out.println();
		int won = count * 100000;
		System.out.println("You guessed " + count + "/10 numbers correctly.");
		System.out.println("You won: $" + won);
	}

	public static int[] getArray(long user){
		int[] ranArray = new int[10];
		
		for(int i = ranArray.length-1; i >= 0; i--){
			ranArray[i] = (int)(user % 10);
			user /= 10;
		}
		return ranArray;
	}


}


