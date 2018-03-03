import java.util.Scanner;
public class Hw5P2 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter the total sales from the store1: ");
		int sale1 = input.nextInt();
		System.out.print("Enter the total sales from the store2: ");
		int sale2 = input.nextInt();
		System.out.print("Enter the total sales from the store3: ");
		int sale3 = input.nextInt();
		System.out.print("Enter the total sales from the store4: ");
		int sale4 = input.nextInt();
		System.out.print("Enter the total sales from the store5: ");
		int sale5 = input.nextInt();

		System.out.println("GRAPH OF TOTAL SALES");
		System.out.println("Each * = $100");
		//Print the first city stars
		int a = 1;
		System.out.print("Store 1: ");
		while((a * 100) <= sale1){
			System.out.print("*");
			a++;
		}
		System.out.println("");

		//Prints the second cities stars
		int b = 1;
		System.out.print("Store 2: ");
		while((b * 100) <= sale2){
			System.out.print("*");
			b++;
		}
		System.out.println("");

		//Prints the third cities stars
		int c = 1;
		System.out.print("Store 3: ");
		while((c * 100) <= sale3){
			System.out.print("*");
			c++;
		}
		System.out.println("");

		//Prints the fourth cities stars
		int d = 1;
		System.out.print("Store 4: ");
		while((d * 100) <= sale4){
			System.out.print("*");
			d++;
		}
		System.out.println("");

		//Prints the third cities stars
		int e = 1;
		System.out.print("Store 5: ");
		while((e * 100) <= sale5){
			System.out.print("*");
			e++;
		}
		System.out.println("");

	}
}
