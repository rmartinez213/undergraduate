

public class Quicksort_Lab9 {

	public static void main(String[] args) {
		int [] A = {14, 10, 13, 4, 7, 9};
		int [] B = {14, 10, 13, 4, 7, 9};
		
		//QUICKSORT W/O RANDOMIZATION
		System.out.println("\n\nBefore quicksort: ");
		for(int i = 0; i < A.length ; i++){
			System.out.print(A[i] + " ");
		}
		
		QuickSort(A, 0, A.length - 1);
		
		System.out.println("\nAfter quicksort: ");
		for(int i = 0; i < A.length ; i++){
			System.out.print(A[i] + " ");
		}
		
		//RANDOMIZE QUICK_SORT
		System.out.println("\n\nBefore randomize quicksort: ");
		for(int i = 0; i < B.length ; i++){
			System.out.print(B[i] + " ");
		}
		
		Randomize_QuickSort(B, 0, B.length - 1);
		
		System.out.println("\nAfter randomize quicksort: ");
		for(int i = 0; i < B.length ; i++){
			System.out.print(B[i] + " ");
		}
		
		
	}
	
	private static void QuickSort(int[] A, int low, int high) {
		if(low < high){
			//int q = RandomizePartition(A, p, r);
			int q = Partition(A, low, high);
			QuickSort(A, low, q - 1);
			QuickSort(A, q + 1, high);
		}
	}

	private static int Partition(int[] A, int low, int high) {
		
		int x = A[high];
		int i = low - 1;
		for(int j = low ; j <= high - 1 ; j++){
			if(A[j] <  x){
				i = i + 1;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		int temp2 = A[i+1];
		A[i+1] = A[high];
		A[high] = temp2;
		return i + 1;
	}
	
	private static void Randomize_QuickSort(int[] A, int low, int high) {
		if(low < high){
			int q = RandomizePartition(A, low, high);
			Randomize_QuickSort(A, low, q - 1);
			Randomize_QuickSort(A, q + 1, high);
		}
	}

	private static int RandomizePartition(int[] A, int low, int high) {
		int i = RANDOM(low, high);
		int temp = A[high];
		A[high] = A[i];
		A[i] = temp;
		return Partition(A,low,high);
	}

	private static int RANDOM(int low_numb, int high_numb) {
		int Ran_int = (low_numb + (int)((Math.random() * (high_numb - low_numb + 1))));
		return Ran_int;
	}
}
