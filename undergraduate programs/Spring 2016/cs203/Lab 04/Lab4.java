
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Lab4 {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		Problem1();
		
		System.out.println();
		System.out.println();

//		System.out.print("Enter a fibonacci number: " );
//		int Fib = input.nextInt();

//		System.out.println("How much time it took to do the recursive: " + getTime(Fib));
//		System.out.println("How much time it took to do the dynamic: " + getTime2(Fib));

		System.out.println("The Fibonacci of 10: " + RecFibonacci(10));
		System.out.println("Recursive for 10: " + getTime(10) + " milliseconds.") ;
		System.out.println("Dynamic for 10: " + getTime2(10) + " milliseconds.");
		System.out.println();
		
		System.out.println("The Fibonacci of 20: " + RecFibonacci(20));
		System.out.println("Recursive for 20: " + getTime(20) + " milliseconds.");
		System.out.println("Dynamic for 20: " + getTime2(20) + " milliseconds.");
		System.out.println();
		
		System.out.println("The Fibonacci of 40: " + RecFibonacci(40));
		System.out.println("Recursive for 40: " + getTime(40) + " milliseconds.");
		System.out.println("Dynamic for 40: " + getTime2(40) + " milliseconds.");
		

	}

	public static long getTime(int n) {

		long startTime = System.currentTimeMillis();

		RecFibonacci(n);

		return System.currentTimeMillis() - startTime;

	}
	
	public static long getTime2(int n) {

		long startTime = System.currentTimeMillis();

		DynFibonacci(n);

		return System.currentTimeMillis() - startTime;

	}


	public static void Problem1(){

		LinkedHashMap<Integer, Integer> IntArray = new LinkedHashMap<>();
		int[] KeyArray = new int[20];
		int KCounter = 0;

		while(true){

			System.out.print("Enter numbers (Enter 0 if you want to quit): ");
			int Number = input.nextInt();

			System.out.println();

			if(Number == 0){
				break;
			}

			if(IntArray.containsKey(Number)){
				int counter = IntArray.get(Number);
				counter++;
				IntArray.put(Number, counter);
			}

			else{
				IntArray.put(Number, 1);
				KeyArray[KCounter] = Number;
				KCounter++;
			}

		}

		int Max = 0;

		for(int j = 0; j < IntArray.size(); j++ ){
			if(IntArray.get(KeyArray[j]) >= Max){
				Max = IntArray.get(KeyArray[j]);
			}
		}

		String NewKeyMax = "";

		for(int i = 0; i < IntArray.size(); i++ ){
			if(IntArray.get(KeyArray[i]) == Max){
				NewKeyMax += KeyArray[i] + " ";
			}
		}

		System.out.println(IntArray.toString());
		System.out.println("The number that occured the most was: " + NewKeyMax);
	}

	public static int RecFibonacci(long fib){
		if(fib == 0){
			return 0;
		}
		if(fib == 1){
			return 1;
		}
		else{
			return RecFibonacci(fib - 1) + RecFibonacci(fib - 2);
		}
	}

	public static void DynFibonacci(int fib){
		long [] FibArray = new long[fib + 1];

		FibArray[0] = 0;
		FibArray[1] = 1;


		for(int i = 2 ; i <= fib ; i++){
			FibArray[i] = FibArray[i - 1] + FibArray[i - 2];
		}
	}
	
}
