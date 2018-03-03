import java.util.Scanner;
public class Hw6P1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a value for x: ");
		int x = input.nextInt();

		for(int i = 1; i <= x ; i++){

			System.out.print(nValue(i) + " ");

			if (i % 7 == 0)
				System.out.println();

		}

	}
	public static int nValue(int x){	
		int n = x * ((7 * x) - 3) / 5;
		return n;
	}
}
