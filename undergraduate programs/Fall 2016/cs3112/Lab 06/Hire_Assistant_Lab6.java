

public class Hire_Assistant_Lab6 {

	public static void main(String[] args) {
		int [] A = {3, 1, 4, 2, 8, 2, 8};
		for(int i = 0; i < A.length ; i++){
			System.out.print(A[i] + " ");
		}
		System.out.println();
		
		Hire_Assistant(A);
	}

	private static void Hire_Assistant(int[] A) {
		int best = 0;
		
		//Candidate 1 will always be hired
		System.out.println("Candidate 1 is hired\n" );
		
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

}
