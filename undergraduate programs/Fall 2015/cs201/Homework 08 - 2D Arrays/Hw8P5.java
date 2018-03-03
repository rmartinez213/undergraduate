import java.util.Scanner;
public class Hw8P5 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {

		System.out.print("Enter the matrix size: ");
		int matrix = input.nextInt();



		char [][] ArrayXO = new char[matrix][matrix];
		ArrayXO = matrixGen(matrix);

		matrixRow(ArrayXO, matrix);
		matrixCol(ArrayXO, matrix);
		matrixMajor(ArrayXO, matrix);
		matrixMinor(ArrayXO, matrix);
	}

	//This methods stores the elements into the array and prints out the elements
	public static char[][] matrixGen(int matrix){
		char[][] matrixArray = new char[matrix][matrix];

		//start storing values
		int check = 0;
		for(int row = 0; row < matrixArray.length ; row++){
			for(int col = 0 ; col < matrixArray[0].length ; col++){
				check = 1 + (int)(Math.random() * (2 - 1 + 1));
				if(check == 1){
					matrixArray[row][col] = 'x';
				}
				else if(check == 2){
					matrixArray[row][col] = 'o';
				}
				System.out.print(matrixArray[row][col] + " ");
			}
			System.out.println();
		}
		return matrixArray;
	}

	public static void matrixRow(char[][]ArrayXO, int matrix){
		int rowcount = 1;
		for(int row = 0 ; row < ArrayXO.length ; row++, rowcount++){
			int count = 0;
			int count2 = 0;
			for(int col = 0 ; col < ArrayXO[0].length ; col++){
				if(ArrayXO[row][col] == 'x'){
					count++;
				}
				else if(ArrayXO[row][col] == 'o'){
					count2++;
				}
				if(count == matrix){
					System.out.println("All x's in row " + rowcount + ".");
				}
				else if(count2 == matrix){
					System.out.println("All o's in row " + rowcount + ".");
				}
			}
		}
	}

	public static void matrixCol(char[][]ArrayXO, int matrix){
		int colcount = 1;
		for(int col = 0 ; col < ArrayXO[0].length ; col++, colcount++){
			int count = 0;
			int count2 = 0;
			for(int row = 0 ; row < ArrayXO.length ; row++){
				if(ArrayXO[row][col] == 'x'){
					count++;
				}
				else if(ArrayXO[row][col] == 'o'){
					count2++;
				}
				if(count == matrix){
					System.out.println("All x's in col " + colcount + ".");
				}
				else if(count2 == matrix){
					System.out.println("All o's in col " + colcount + ".");
				}
			}
		}
	}

	public static void matrixMajor(char[][]ArrayXO, int matrix){
		int count = 0;
		int count2 = 0;
		for(int row = 0 ; row < ArrayXO.length ; row++){

			for(int col = 0 ; col < ArrayXO[0].length ; col++){
				if(row == col && ArrayXO[row][col] == 'x'){
					count++;
				}
				else if(row == col && ArrayXO[row][col] == 'o'){
					count2++;
				}
			}
		}

		if(count == matrix){
			System.out.println("All x's in major diagnol.");
		}
		else if(count2 == matrix){
			System.out.println("All o's in major diagnol.");
		}


	}

	public static void matrixMinor(char[][]ArrayXO, int matrix){
		int count = 0;
		int count2 = 0;
		for(int row = 0, statcount = 0 ; row < ArrayXO.length ; row++, statcount++){

			for(int col = ArrayXO[0].length - 1, statcount2 = 0 ; col >= 0 ; col--, statcount2++){
				if(statcount == statcount2 && ArrayXO[row][col] == 'x'){
					count++;
				}
				else if(statcount == statcount2 && ArrayXO[row][col] == 'o'){
					count2++;
				}
			}
		}
		if(count == matrix){
			System.out.println("All x's in minor diagnol.");
		}
		else if(count2 == matrix){
			System.out.println("All o's in minor diagnol.");
		}
	}

}
