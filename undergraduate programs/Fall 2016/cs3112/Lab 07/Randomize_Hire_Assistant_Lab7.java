
public class Randomize_Hire_Assistant_Lab7 {

	public static void main(String[] args) {
		int[] A = {2, 3, 5, 4, 7, 6, 10};
		
		/*
		 * Implementing a randomize hiring algorithm where the time
		 * complexity is (nlogn)
		 */
		
		System.out.println("Before Randomize In Place: ");
		for(int i = 0; i < A.length ; i++){
			System.out.print(A[i] + " ");
		}
		Randomize_In_Place(A);

		System.out.println("\nAfter Randomize In Place: ");
		for(int i = 0; i < A.length ; i++){
			System.out.print(A[i] + " ");
		}

		Hire_Assistant(A);
	}

	//switches elements around the array...
	private static void Randomize_In_Place(int[] A) {
		for(int i = 0 ; i < A.length; i++){
			int Int_Temp = Ran(i, A.length - 1);
			int temp = A[Int_Temp];
			//System.out.println(temp);
			A[Int_Temp]= A[i];
			A[i] = temp;
		}
	}

	private static void Hire_Assistant(int[] A) {
		int best = 0;

		//Candidate 1 will always be hired
		System.out.println("\n\nCandidate 1 is hired\n" );

		for(int i = 1 ; i < A.length; i++){
			if(A[i] > A[best]){
				System.out.println("Candidate " + (best + 1) + " is fired");
				best = i;
				System.out.println("Candidate " + (best + 1) + " is hired\n");
			}

		}

		System.out.println("\nThe best candidate highered is candidate: " + (best + 1));
		System.out.println("The candidate has a value of: " + A[best]);
	}

	//A method that randomizes the numbers 
	private static int Ran(int i, int length) {
		int Ran_int = ((int)(i + (Math.random() * (length - i + 1))));
		return Ran_int;
	}

}
