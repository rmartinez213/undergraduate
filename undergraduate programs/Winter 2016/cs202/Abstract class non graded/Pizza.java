package AbstractPizza;
import java.util.Scanner;

public abstract class Pizza {

	public abstract void getArea();

	public abstract int getTopping();

	public static void addTopping(int toppings){

		Scanner input = new Scanner(System.in);

		System.out.println("How many toppings would like to add?");
		int Add = input.nextInt();

		int TotalToppings = toppings + Add;
		
		System.out.println("You now have a total of " + TotalToppings + " toppings.");
		
		
		SubtractTopping(TotalToppings);

	
	}

	public static void SubtractTopping(int toppings){
		
		Scanner input = new Scanner(System.in);

		System.out.println("How many toppings would like to take out?");
		int Subtract = input.nextInt();

		int TotalToppings = toppings - Subtract;

		System.out.println("You now have a total of " + TotalToppings + " toppings.");
	}

}
