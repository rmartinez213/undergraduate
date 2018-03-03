import java.util.Scanner;
public class Hw6P2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the five scores: ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		double d = input.nextDouble();
		double e = input.nextDouble();

		getTablePrint(a,b,c,d,e);
	}

	public static void getTablePrint(double a, double b, double c, double d, double e){

		System.out.println("----------------Grades----------------");
		System.out.println("Test # \t        Score \t       Letter");
		System.out.println("--------------------------------------");
		System.out.println("Test 1: \t" + a + "%" + "\t\t" + getLetter(a));
		System.out.println("Test 2: \t" + b + "%" + "\t\t" + getLetter(b));
		System.out.println("Test 3: \t" + c + "%" + "\t\t" + getLetter(c));
		System.out.println("Test 4: \t" + d + "%" + "\t\t" + getLetter(d));
		System.out.println("Test 5: \t" + e + "%" + "\t\t" + getLetter(e));
		System.out.println("--------------------------------------");
		System.out.printf("Average: \t%3.2f%% \t\t%s",getAverage(a,b,c,d,e), getLetter(getAverage(a,b,c,d,e)));
	}

	//Gets the average of all 5 test scores
	public static double getAverage(double a, double b, double c, double d, double e){
		double Average = (a + b + c + d + e) / 5; 
		return Average;
	}

	//Gets the letter grade of test scores and average grade of test scores
	public static String getLetter(double grade){
		if (grade >= 90.0)
			return "A";
		else if (grade >= 80.0)
			return "B";
		else if (grade >= 70.0)
			return "C";
		else if (grade >= 60.0)
			return "D";
		else
			return "F";
	}
}
