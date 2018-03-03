import java.util.Scanner;
public class Hw7P1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int user = getUser(input);

		System.out.print("Enter the scores: ");

		//This creates an array and adds the values user inputs
		double [] myMany = new double[user];

		//This calculate the average in method "average"
		double average = AverageTruncated(myMany,user);

		int count = 0;
		int count1 = 0;
		int count2 = 0;
		double scores = 0;
		for(int i = 0 ;i < myMany.length ; i++){
			scores = Math.floor(myMany[i] * 100)/ 100;
			if(scores > average){
				count++;
			}
			if(scores == average){
				count1++;
			}

			if(scores < average){
				count2++;
			}
		}
		//This will print out the average and the counted numbers
		printOut(average, count, count1, count2);
	}

	public static int getUser(Scanner input){
		System.out.print("How many scores are there? ");
		int user = input.nextInt();
		return user;
	}
	//Gets the average of all numbers
	public static double AverageTruncated(double[] myMany, int user){
		double AverageBeta = average(myMany) / user;
		double average = Math.floor(AverageBeta * 100) /100;
		return average;
	}

	//Print out the average, etc. 
	public static void printOut(double average, int count, int count1, int count2){
		System.out.println("Average: " + average);
		System.out.println("Scores > Average: " + count);
		System.out.println("Scores = Average: " + count1);
		System.out.println("Scores < Average: " + count2);
	}

	//Gets the addition of all numbers
	public static double average(double[] myMany){
		Scanner input = new Scanner(System.in);

		double scores = 0;
		double average = 0;

		for(int i = 0; i < myMany.length; i++){
			myMany[i] = input.nextDouble();
			scores = Math.floor(myMany[i] * 100)/ 100;
			average += scores;
		}

		return average;
	}
}
