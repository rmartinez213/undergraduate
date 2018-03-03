import java.util.Scanner;
public class Hw4P3{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		System.out.print("Enter the first city: ");
		String city1  = input.nextLine();

		System.out.print("Enter the second city: ");
		String city2 = input.nextLine();

		System.out.print("Enter the third city: ");
		String city3 = input.nextLine();

		int a = city1.compareToIgnoreCase(city2);
		int b = city1.compareToIgnoreCase(city3);

		int c = city2.compareToIgnoreCase(city1);
		int d = city2.compareToIgnoreCase(city3);

		int e = city3.compareToIgnoreCase(city1);
		int f = city3.compareToIgnoreCase(city2);

		if (((a < 0) && (b < 0)) && (d < 0)){
			System.out.println("Alphabetical Order: " + city1 + ", " + city2 + ", " + city3);
		}
		else if (((a < 0) && (b < 0)) && (f < 0)){
			System.out.println("Alphabetical Order: " + city1 + ", " + city3 + ", " + city2);
		}
		if (((c < 0) && (d < 0)) && (e > 0)){
			System.out.println("Alphabetical Order: " + city2 + ", " + city1 + ", " + city3);
		}
		else if (((c < 0) && (d < 0)) && (b > 0)){
			System.out.println("Alphabetical Order: " + city2 + ", " + city3 + ", " + city1);
		}
		if (((e < 0) && (f < 0)) && (c < 0)){
			System.out.println("Alphabetical Order: " + city3 + ", " + city2 + ", " + city1);
		}
		else if (((e < 0) && (f < 0)) && (a < 0)){
			System.out.println("Alphabetical Order: " + city3 + ", " + city1 + ", " + city2);
		} 
	}
}