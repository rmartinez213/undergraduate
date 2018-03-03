package Lab;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab1 {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int value = 5;
		String Value = "Hello World";

		//Displays the number in reverse
		System.out.print("Reverse Display: ");
		reverseDisplay(5);

		//Displays the word in reverse
		System.out.print("Reverse Display Word: ");
		reverseDisplay(Value);
		
		//Displays the sorted number from user input
		System.out.print("\rSelection Sort: ");
		System.out.println();
		recursiveSort();

		

		//Displays the square root of the Nth power from user
		System.out.println("EXTRA CREDIT (18.4)");
		System.out.print("What do you want for N number (2^n): ");
		int n = input.nextInt();
		ComputingN(n, 1, 1);

		
		System.out.println("EXTRA CREDIT (18.5)");
		//Displays the square root of the Xth
		System.out.print("What do you want for X number (x^n): ");
		int x = input.nextInt();
		System.out.print("What do you want for n number (x^n): ");
		int NewN = input.nextInt();
		ComputingXANDN(NewN, 1, 1, x);
		
		System.out.println();
		System.out.println("EXTRA CREDIT (18.6)");
		//Displays the mathematical function (Summation) for a positive integer N
		System.out.print("What do you want for your summation of N (1+2+3+4...+n)? ");
		int SumN = input.nextInt();
		ComputingMathN(SumN, 0, 1);
		
		System.out.println("EXTRA CREDIT (18.11)");
		isPalindromeExtra();
	}

	public static void reverseDisplay(int value){

		if(value == 0)
			System.out.println(0);

		else{
			System.out.print(value + " ");
			reverseDisplay(value - 1);
		}
	}

	public static void reverseDisplay(String value){
		int total = value.length();

		if(total == 0){
		}

		else{
			String letter = value.substring(total - 1, total);
			String letter2 = value.substring(0, total - 1);
			System.out.print(letter);
			reverseDisplay(letter2 + "");
		}
	}

	public static void recursiveSort(){
		System.out.print("How many would you like to sort? ");
		int ArrayLength = input.nextInt();
		int[] MyList = new int[ArrayLength];

		int count = 1;
		for(int i = 0; i < MyList.length ; i++, count++){
			System.out.print("Please type in your " + count + " number: ");
			MyList[i] = input.nextInt();
		}

		for(int i = 0 ; i < MyList.length ; i++){
			for(int j = i + 1 ; j < MyList.length ; j++){
				if(MyList[i] > MyList[j]){
					int temp = MyList[j];
					MyList[j] = MyList[i];
					MyList[i] = temp;
				}
				else{

				}
			}
		}

		for(int i = 0 ; i < MyList.length ; i++){
			System.out.print(MyList[i] + " ");
		}

		System.out.println();
		BinSearch(MyList);
	}

	public static int BinSearch(int[] MyList){
		System.out.print("What would you like your key to be? ");
		int key = input.nextInt();

		int LValue = 0;
		int HValue = MyList.length - 1;
		int MValue = 0;

		while(HValue >= LValue){
			MValue = (LValue + HValue) / 2;

			if(key == MyList[MValue]){
				System.out.print("Your key is in index: ");
				System.out.print(MValue + 1);
				return MValue;
			}

			else if(key < MyList[MValue]){
				HValue = MValue - 1;
			}
			else if(key > MyList[MValue]){
				LValue = MValue + 1;
			}
		}
		if( key != MyList[MValue]){
			System.out.print("Key is not found: ");
			System.out.println(-1);
			return -1;
		}
		return 0;
	}

	public static void ComputingN(int n, int count, int amount){

		amount *= (2);

		if(n == count){
			System.out.println(amount);	
		}
		else{
			//System.out.println(amount);
			ComputingN(n, count + 1, amount);
		}
	}

	public static void ComputingXANDN(int n, int count, int amount, int x){

		amount *= (x);

		if(n == count){
			System.out.print("Your number is: " + amount);	
		}
		else{
			//System.out.println(amount);
			ComputingXANDN(n, count + 1, amount, x);
		}
	}

	public static void ComputingMathN(int n, int total, int count){
		
		total += count;
				
		if(n == count){
			System.out.println("Your total is: " + total);
		}
		else{
			ComputingMathN(n, total, count + 1);
		}
	}
	
	public static void isPalindromeExtra(){
		System.out.println("The base cases(2 base cases) determine whether the recursive method should continue. The method is called 5 times.");
	}

}
