import java.util.Scanner;
public class Hwp5 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter an integer: ");
		int user = input.nextInt();

		//Pattern A
		String sum = "";
		for (int a = 1; a <= (user); a++){
			int b = 1;
			while (a <= user){
				sum = sum + " " + a ;
				System.out.println(sum);
				a++;

			}
		}
		//Pattern B
		for (int a = user; a > 0; a--){
			for(int b = 1; b <= a ; b++){
				System.out.print(" " + b );
			}
			System.out.println();
		}

		//Pattern C

		for(int i = 1, z = 0; i <= user ; i++, z++){
			for (int k = user ; k > z; k--){
				System.out.print("  ");
				//System.out.print();
			}
			for(int j = i, p = 1 ; j > 0 ; j--, p++){
				System.out.print(p + " ");
			}
			System.out.println();

		}

		//Pattern D
		for (int a = user, n = 1; a > 0; a--, n++){
			for(int m = 0; m < n ; m++){
				System.out.print("  ");
			}
			for(int b = 1; b <= a ; b++){
				System.out.print(b + " " );
			}
			System.out.println();
		}



		System.out.println();

	}

}
