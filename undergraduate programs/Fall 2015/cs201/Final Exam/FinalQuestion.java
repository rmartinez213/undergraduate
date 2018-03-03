import java.util.Scanner;
public class FinalQuestion {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("How many students?");
		int students = input.nextInt();

		System.out.print("How many tests?");
		int tests = input.nextInt();

		int[][] Array = new int [students][tests];
		Array = TableA(Array);

		double[] ArrayB = new double[tests];
		ArrayB = TableB(tests, ArrayB);

		ArrayTableA(Array);
		ArrayTableB(ArrayB);
		StudentAverage(students, tests, Array);
		ClassAverage(students, tests, Array);
	}

	public static int[][] TableA(int[][]Array){
		int Student = 0;
		int TestNumber = 1;

		//This loop will create the 2d array asking the user for the scores of each student  
		for(int row = 0 ; row < Array.length ; row++){
			Student++;
			for(int col = 0 ; col < Array[row].length ; col++){
				System.out.println("What is student " + Student + " test " + TestNumber +  " grade?");
				Array[row][col] = input.nextInt();
				TestNumber++;
			}
			TestNumber = 1;
		}
		//This loop will print out all 

		return Array;
	}

	public static double[] TableB(int tests, double[] ArrayB){
		System.out.println();

		for(int col = 0, test = 1; col < ArrayB.length ; col++, tests++){
			System.out.println("Exam " + test + " weights?");
			ArrayB [col] = input.nextDouble();
			test++;
		}
		return ArrayB;
	}

	public static void ArrayTableA(int[][] Array){
		for(int row = 0 ; row < Array.length ; row++){
			for(int col = 0 ; col < Array[row].length ; col++){
				System.out.printf("%5d", Array[row][col]);
			}
			System.out.println();
		}

	}

	public static void ArrayTableB(double[] ArrayB){
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		for(int col = 0, test = 1; col < ArrayB.length ; col++){
			System.out.print(ArrayB[col] + "   ");
		}
	}

	public static void StudentAverage(int students, int tests, int [][] Array){

		double sum = 0;
		double average = 0;
		System.out.println();
		for(int row = 0, Counter2 = 1 ; row < students ; row++){
			for(int col = 0 ; col < Array[0].length ; col++){
				sum += Array[row][col];
			}
			average = (sum / (double)tests);
			System.out.println("Student" + Counter2 + " average is: "  + average);
			Counter2++;
			sum = 0;
		}

	}

	public static void ClassAverage (int students, int tests ,int[][] Array){
		int sum = 0;
		double ClassAverage = 0;
		System.out.println();
		for(int row = 0, average = 0, Counter2 = 1 ; row < students ; row++){
			for(int col = 0 ; col < Array[0].length ; col++){
				sum += Array[row][col];
			}
			average = (sum / tests);
			ClassAverage += average;
			Counter2++;
			sum = 0;
		}

		double TotalClassAverage = (ClassAverage / (double)students);

		System.out.printf("The class average is: %2.2f", TotalClassAverage);
	}
}
