import java.util.Scanner;
public class Hw8P4 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.print("Enter a number between 0 and 511: ");
		int Entered = input.nextInt();

		getPrint(Entered);
		getPrintArray(getPrint(Entered));

	}

	public static char[][] getPrint(int Entered){
		char[][] table = new char[3][3];

		for(int row = table.length -1; row >= 0 ; row--){
			for(int col = table[0].length-1 ; col >= 0 ; col--){

				int check = Entered % 2;
				if(check == 1){
					table[row][col] = 'T';
				}
				else if(check == 0){
					table[row][col] = 'F';
				}
				Entered /= 2;			
			}
		}
		return table;
		
	}
	
	public static void getPrintArray(char[][] table){
		
		for(int row = 0; row < table.length ; row++){
			for (int col = 0 ; col < table[0].length ; col++){
				System.out.print(table[row][col] + " ");
			}
			System.out.println();
		}
	}

}
