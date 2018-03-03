
public class Count_Bucket_Radix_Lab_10 {

	public static void main(String[] args) {
		
		/* 
		 *  Counting sort runs in n time. And Bucket sort run in whatever sorting 
		 *  algorithm is implemented with bucket sort
		 */
		
		/*				Counting Sort Algorithm Starts Here			*/
		System.out.println("Counting Sort\n");
		
		int [] A = {14, 10, 13, 4, 7, 9, 3, 5, 3, 5};
		int [] B = new int [A.length + 1];
		
		//Gets the highest number in the array
		int k = 0;
		for(int i = 0 ; i < A.length ; i++){
			if(A[i] > k)
				k = A[i];
		}
		
		CountingSort(A, B, k);
		/*				Counting Sort Algorithm Starts Here			*/
		
		
		
		System.out.println("\n");
		
		
		
		
		/*				Bucket Sort Algorithm Starts Here			*/
		int [] NewA = {14, 10, 13, 4, 7, 9, 3, 5};
		
		
		
		BucketSort(NewA);
		
		/*				Bucket Sort Algorithm Ends Here				*/
	}

	private static void CountingSort(int[] A, int[] B, int k) {
		
		/* 			Prints out the before sorting algorithm		*/
		System.out.print("Before counting sort: ");
		for(int i = 0 ; i < A.length ; i++){
			System.out.print(A[i] + " ");
		}
		System.out.println();
		
		
		
		//C goes all the way to 14
		int [] C = new int [k + 1];
//		System.out.println("The amount of index in C");
		
		for(int i = 0; i < C.length ; i++){
			C[i] = 0;
//			System.out.println(i);
		}
		
//		System.out.println("Tester loop2: ");
		for(int j = 0 ; j < A.length ; j++){
			C[A[j]] = C[A[j]] + 1;
//			System.out.println(C[A[j]]);
		}
		
		for(int i = 1 ; i < C.length ; i++){
			C[i] = C[i] + C[i-1];
//			System.out.println(C[i] + " "+ i);
		}
		//System.out.println("Test 14:" + C[14]);
		
		for(int j = A.length - 1; j >= 0 ; j--){
			B[C[A[j]]] = A[j];
//			System.out.println();
//			System.out.print(A[j] + " with index " + j + "\t " + C[A[j]]);
			C[A[j]] = C[A[j]] - 1;
//			System.out.print("\tAfter " + C[A[j]] + "\t " + B[C[A[j]]]);
		}
		
		
		/* 			Prints out the after sorting algorithm		*/
		System.out.print("\nAfter Counting sort: ");
		for(int i = 1 ; i < B.length ; i++)
			System.out.print(B[i] + " ");
	}
	
	private static void BucketSort(int[] A){
		
		/* Prints out the before sorting algorithm */
		System.out.println("BucketSort\n");
		
		System.out.print("Before bucket sort: ");
		for(int i = 0 ; i < A.length ; i++){
			System.out.print(A[i] + " ");
		}
		System.out.println();
		
		
		
		//Gets the highest number in the array
		int MaxNum = 0;
		for(int i = 0 ; i < A.length ; i++){
			if(A[i] > MaxNum)
				MaxNum = A[i];
		}
		
		int[] B = new int [MaxNum + 1];
		
		for(int i = 0 ; i < B.length ; i++){
			B[i] = 0;
		}
		
		for(int i = 0 ; i < A.length; i++){
			 B[A[i]]++;
		}
		
		//implementing insertion sort with bucket
		int BucketPosition = 0;
		
		for(int i = 0 ; i < B.length ; i++){
			for(int j = 0 ; j < B[i] ; j++){
				A[BucketPosition] = i;
				BucketPosition++;
			}
		}
		
		
		/* 			Prints out the after sorting algorithm		*/
		System.out.print("\nAfter bucket sort: ");
		for(int i = 0 ; i < A.length; i++)
			System.out.print(A[i] + " ");
		
	}
}