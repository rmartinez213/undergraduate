import java.util.Scanner;
public class MidtermQ1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("How many numbers to generate fibonachi?: ");
		int user = input.nextInt();
		int a = 0;
		for(int i = 1, b = 1, c = 1, d = 0; i <= user ; i++){
			c = b;
			b = d;
			d = b + c;
			System.out.println(d);
		}
	}
}
//