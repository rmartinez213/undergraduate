

public class Lab4 {

	public static void main(String[] args) {
		// [c][r]
		
		int [][] ArrayA = {{4, 7, 5, 2},
						   {9, 3, 4, 6},
						   {3, 4, 1, 9},
						   {3, 5, 1, 6}};
		
		int [][] ArrayB = {{6, 9, 3, 6},
						   {2, 7, 4, 2},
						   {6, 8, 2, 1},
						   {3, 1, 6, 9}};
		
		int [][] ArrayC = new int [4][4];
		
		SquareMatrixMultiN3(ArrayA, ArrayB, ArrayC);
	}
	
	public static void SquareMatrixMultiN3(int[][] arrayA, int[][] arrayB, int[][] arrayC){
		int n = arrayA.length;
		
		for(int i = 0 ; i < n ;i++){
			for(int j = 0 ; j < n ; j++){
				arrayC[i][j] = 0;
				for(int k = 0; k < n ; k++){
					//	First Iteration: 4 * 6 = 24	Second Iteration: 14 + 24  Third Iteration: 
					arrayC[i][j] = arrayC[i][j] + arrayA[i][k] * arrayB[k][j];
				}
			}
		}
		
		System.out.println("Matrix Array");
		System.out.println();
		for(int row = 0; row < arrayC.length ; row++){
			for(int col = 0; col < arrayC.length ; col++){
				System.out.print(arrayC[row][col] + "\t");
			}
			System.out.println();
		}
	}

}
