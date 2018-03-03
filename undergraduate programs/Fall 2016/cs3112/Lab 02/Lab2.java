
public class Lab2 {
	
	//Merge Algorithm

	public static void main(String[] args) {
		int [] A = {5, 2, 4, 7, 1, 3, 2, 6};
		
		System.out.println("Before merge sort: ");
		
		for(int i = 0 ; i < A.length ; i++) {
			System.out.print(A[i] + " ");
		}
		
		Merge_Sort(A, 0, A.length - 1);
		System.out.println("\rAfter merge sort: ");
		PrintArray(A);
	}
	
	public static void Merge_Sort(int[] A, int p, int r){
		if(p < r){
			int q = (int) Math.floor((p + r)/ 2);
			Merge_Sort(A, p, q);
			Merge_Sort(A, q + 1, r);
			Merge(A, p, q, r);
		}
	}

	public static void Merge (int[] A, int p, int q, int r){
		int n1 = q - p + 1;
		int n2 = r - q;
		
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		
		//First Loop
		for(int i = 0; i < n1 ; i++){
			L[i] = A[p + i];
		}
		
		//Second Loop
		for(int j = 0; j < n2 ; j++){
			R[j] = A[q + j + 1];
		}
		
//		L[n1 + 1] = infinite;
//		R[n2 + 1] = infinite;
		int i = 0;
		int j = 0;
		
		
		//Sorts the two arrays as one array *** Array "A"
		for(int k = p ; k <= r ; k++){
			if(i == n1){
				A[k] = R[j];
			}
			
			else if(j == n2){
				A[k] = L[i];
			}
			
			else if(L[i] <= R[j]){
				A[k] = L[i];
				i = i + 1;
			}
			else{
				A[k] = R[j];
				j = j + 1;
			}
		}
	}
	
	
	public static void PrintArray(int[] A){
		for(int run = 0 ; run < A.length ; run++){
			System.out.print(A[run] + " ");
		}
	}
	
	/*Pseudo Code (Chapter 2, Pg 34)
	 * 
	 * n1 = q - p + 1
	 * n2 = r - q
	 * 
	 * let L[1..n1 + 1] and R[1..n2 + 1] be new arrays
	 * 
	 * 
	 * L[n1 + 1] = infinite       <------sentinel card
	 * R[n2 + 1] = infinite
	 * 
	 */
	
}
