import java.util.Scanner;
public class Hw6P4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the number of rows and columns: ");
		int user = input.nextInt();
		int user2 = input.nextInt();

		System.out.println();
		getRowCol(user, user2);
	}

	public static void getRowCol(int user, int user2){
		//First for loop is for  rows and second row is for columns
		for(int j = 0; j < user ; j++){
			int i = 0;
			for (; i < user2 ; i++){
				int random = 33 + (int)(Math.random() * (126 - 33 + 1));
				System.out.print((char)random + " ");
			}
			System.out.println();

		}
	}
}

