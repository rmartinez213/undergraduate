import java.util.Scanner;
public class Hw8P1 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("How many rows? ");
		int rows = input.nextInt();

		System.out.print("How many columns? ");
		int columns = input.nextInt();

		int[][] Array = new int[rows][columns];
		Array = ArrayRandPrint(Array);


		ArrayAverage(Array);
		ArrayCol(Array);
		ArrayRow(Array);
		ArrayMajorD(Array);
		ArrayMinor(Array);
	}

	public static int[][] ArrayRandPrint(int[][] Array){

		for(int r = 0 ; r < Array.length ; r++){
			for(int c = 0 ; c < Array[r].length ; c++){

				Array[r][c] = 0 + (int)(Math.random() * (9 - 0 + 1));
				System.out.print(Array[r][c] + " ");
			}
			System.out.println();
		}
		return Array;
	}

	public static void ArrayAverage(int[][] Array){

		int Sum = 0;
		int count = 0;
		System.out.println();
		for(int r = 0 ; r < Array.length ; r++){
			for(int c = 0 ; c < Array[r].length ; c++){
				Sum += Array[r][c];
				count += 1;
			}
		}
		double Average = (double)Sum / (double)count;
		System.out.printf("The the sum of the entire array is %2d and the average is %3.2f.", Sum, Average);
	}

	public static void ArrayCol(int[][] Array){


		System.out.println();
		int count = 0;

		for(int c = 0 ; c < Array[0].length ; c++){
			int SumCol = 0;
			int count2 = 0;
			for(int r = 0 ; r < Array.length ; r++){
				SumCol += Array[r][c];
				count2 += 1;
			}
			count += 1;
			double Average = (double)SumCol / (double)count2;
			System.out.printf("The sum of column %1d is %2d and the average is %3.2f. \n", count, SumCol, Average);
		}

	}

	public static void ArrayRow(int[][] Array){
		System.out.println();

		int count = 0;

		//This loops get the rows length
		for(int c = 0 ; c < Array.length ; c++){
			int SumRow = 0;
			int count2 = 0;
			//This loop gets the columns length
			for(int r = 0 ; r < Array[0].length; r++){
				SumRow += Array[c][r];
				count2 += 1;
			}
			count += 1;
			double Average = (double)SumRow / (double)count2;
			System.out.printf("The sum of row %1d is %2d and the average is %3.2f. \n", count, SumRow, Average);
		}
	}

	public static void ArrayMajorD(int [][] Array){
		System.out.println();

		System.out.println();
		int SumMajor = 0;
		int count = 0;
		for(int c = 0 ; c < Array.length ; c++){


			for(int r = 0 ; r < Array[c].length ; r++){
				if(r == c){
					SumMajor += Array[r][c];
					count += 1;
				}
			}
		}
		double Average = (double)SumMajor / (double)count;
		System.out.printf("The sum of %1d majors are %2d and the average is %3.2f. \n", count, SumMajor, Average);

	}

	public static void ArrayMinor(int[][] Array){
		int Count = 0;
		int SumMinor = 0;
		int Sum = 0;
		double Average2 = 0;
		for(int row = 0 ; row <= Array.length; ){
			for(int col = Array[0].length-1; col >= 0; col--, row++){
				if(col >= 0){
					SumMinor += Array[row][col];
					Sum = SumMinor;
					Count++;	
				}
				if(row == Array.length-1){
					break;
				}			
			}		
			double Average = (SumMinor / Count);
			Average2 = Average;	
			break;		
		}

		double Average = (double)SumMinor / (double)Count;
		System.out.printf("The sum of %1d minors are %2d and the average is %3.2f. \n", Count, SumMinor, Average2);


	}






}
