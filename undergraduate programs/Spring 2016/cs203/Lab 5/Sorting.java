
import java.util.Scanner;


public class Sorting<E> {

	static Scanner input = new Scanner(System.in); 


	public static <E extends Comparable<E>> void main(String[] args) {

		Integer[] list = {12, 3, 9, 4, 8, 5, 1, 14, 11};
		insertionSort(list);
		bubbleSort(list);
		
		System.out.println("\rMerge sort in code, not printed...");
		mergeSort(list); 
	}

	public static <E extends Comparable<E>> void insertionSort(E[] list){


		for (int a = 1; a < list.length; a++) {

			E Current = list[a]; 
			int b;

			for (b = a - 1; b >= 0 && (int)list[b] > (int)Current; b--) { 
				list[b + 1] = list[b];
			}
			list[b + 1] = Current;
		}

		System.out.println("Insertion Point: " );

		for(int j = 0 ; j < list.length ; j++){
			System.out.print(list[j] + "  ");
		}


	}

	public static <E extends Comparable<E>> void bubbleSort(E[] list){

		for(int i = 0 ; i < list.length ; i++){
			for(int j = i + 1 ; j < list.length ; j++){
				if((int)list[i] > (int)list[j]){
					E temp = (E)list[j];
					list[j] = (E)list[i];
					list[i] = temp;
				}
			}
		}

		System.out.println();
		System.out.println("Bubble Sort: " );

		for(int j = 0 ; j < list.length ; j++){
			System.out.print(list[j] + "  ");
		}
	}

	public static <E extends Comparable<E>> void mergeSort(E[] list) { 
		
		if (list.length > 1) { 
			E[] firstHalf = (E[])new Comparable[list.length / 2]; 
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf); 
			int secondHalfLength = list.length - list.length / 2; 
			E[] secondHalf = (E[])new Comparable[secondHalfLength]; 
			System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf); 
			merge(firstHalf, secondHalf, list);
		} 
	}
	
	public static <E extends Comparable<E>> void merge(E[] FHalf, E[] SHalf, E[] list) {
		int present1 = 0;
		int present2 = 0; 
		int present3 = 0; 
		while (present1 < FHalf.length && present2 < SHalf.length) { 
			if ((int)FHalf[present1] < (int)SHalf[present2]) 
				list[present3++] = FHalf[present1++]; 
			else 
				list[present3++] = SHalf[present2++]; 
		} 
		while (present1 < FHalf.length)
			list[present3++] = FHalf[present1++]; 
		while (present2 < SHalf.length) 
			list[present3++] = SHalf[present2++]; 	
	} 
}