
public class Heap_Sort {

	static int Size;
	public static void main(String[] args) {
		int[] A = {4, 1, 8, 12, 9, 11, 5, 15};
		
		
		System.out.println("Before heap sort: ");
		for (int i = 0 ; i < A.length; i++){
			System.out.print(A[i] + " ");
		}
		
		HeapSort(A);
		
		System.out.println("\nAfter heap sort: ");
		for (int i = 0 ; i < A.length; i++){
			System.out.print(A[i] + " ");
		}

	}
	
	public static void HeapSort(int[] A){
		Build_Max_Heap(A);
		for(int i = A.length - 1 ; i >= 1 ; i--){
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			
			Size = Size - 1;
			Max_Heapify(A, 0);
		}
	}
	
	public static void Build_Max_Heap(int[] A){
		Size = A.length;
		for(int i = (int)Math.floor(A.length / 2) ; i >= 0 ; i--){
			Max_Heapify(A, i);
		}
	}
	
	public static void Max_Heapify(int[] A, int i){
		int l = Left_Child(i);
		int r = Right_Child(i);
		int largest = -1;
		
		if( (l < Size) && (A[l] > A[i]) ){
			largest = l;
		}
		
		else{
			largest = i;
		}
		
		if( (r < Size) && (A[r] > A[largest]) ){
			largest = r;
		}
		
		if(largest != i){
			int swap = A[i];
			A[i] = A[largest];
			A[largest] = swap;
			Max_Heapify(A, largest);
		}
			
	}
	
	private int Parent(int i){
		return (int)Math.floor(i / 2);
	}
	private static int Left_Child(int i){
		return (2*i);
	}
	private static int Right_Child(int i){
		return ((2*i) + 1);
	}

}
