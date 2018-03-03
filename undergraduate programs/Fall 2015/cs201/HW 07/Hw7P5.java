import java.util.Scanner;
public class Hw7P5 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter a value for n: " );
		int n = input.nextInt();
		System.out.println();

		getMatching(printRandom(n), n);
	}


	public static int[] printRandom(int n){
		int[] numbers = new int[100];
		int number = 0;
		System.out.println("The random numbers are: ");
		for(int x = 0, a = 1; x < 100; x++, a++){
			numbers[x] = 1 + (int)(Math.random() * (n - 1 + 1));
			System.out.print(numbers[x] + " ");
			//Create 10 numbers per line

			if(numbers[x] > 9){
				System.out.print("");
			}
			else{
				System.out.print(" ");
			}
			if(a % 10 == 0){
				System.out.println();
			}
		}
		return numbers;
	}

	public static void getMatching(int[] numbers,int n){
		int count = 0;

		for(int y = 0, a = 1; a <= n ;){
			if(a == numbers[y]){
				y++;
				count++;
			}
			
			else {
				y++;
			}
			if(y == numbers.length){
				 y = 0;
				 System.out.println( a + " appears " + count + " times.");
				 count = 0;
				 a++;
			}
			
		}
	}
}