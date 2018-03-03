package Lab;
import java.util.Scanner;

public class Lab1 {

	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {

		int[] A =  {5, 2, 4, 6, 1, 3};


		for(int j = 1; j < A.length ; j++){
			
			int key = A[j];
			int i =  j - 1;
			
			while((i >= 0) && (A[i] > key)){
				A[i+1] = A[i];
				i = i - 1;
			}
			A[i+1] = key;
		}
		
		//This line of code checks to see
		for(int b = 0 ; b < A.length ; b++){
			System.out.print(A[b] + " ");
		}
		System.out.println();
		
		
		System.out.println("What number from the array would you like your key to be? ");
		int key = input.nextInt();
		
		System.out.println(BinaryS(key, A));
	}
	
	public static int BinaryS(int key, int[] Array){
		
		int low = 0;
		int high = Array.length - 1;
		
		while(low <= high){
			int middle = (low + high) / 2;
			
			if(Array[middle] == key){
				return middle;
			}
			else if(Array[middle] < key){
				low = middle + 1;
			}
			else if(Array[middle] > key){
				high = middle -1;
			}
		}
		return -1;
	}
}
