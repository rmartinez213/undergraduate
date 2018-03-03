
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TimeSorting extends Application{



	@Override
	public void start(Stage primaryStage) throws Exception {
		//Creates list used to execute 
		int[] Array = new int[10000];
		int[] Array2 = new int[15000];
		int[] Array3 = new int[20000];
		int[] Array4 = new int[25000];
		int[] Array5 = new int[30000];
		int[] Array6 = new int[35000];

		BorderPane BPane = new BorderPane();
		Text DisplayTxt = new Text();


		DisplayTxt.setText("Array Size\t\t Selection Sort\t\t Insertion Sort\t\t Bubble Sort\t\t Merge Sort\t\t Quick Sort\t\t Heap Sort\t\r" +
				"10,000\t\t" + getTime(Array) + "\t\t\t\t" + getTime2(Array) + "\t\t\t\t" + getTime3(Array) + "\t\t\t\t" + getTime4(Array) + "\t\t\t\t" + getTime5(Array) + "\t\t\t\t" + getTime6(Array) + "\r" +
				"15,000\t\t" + getTime(Array2) + "\t\t\t\t" + getTime2(Array2) + "\t\t\t\t" + getTime3(Array2) + "\t\t\t\t" + getTime4(Array2) + "\t\t\t\t" + getTime5(Array2) + "\t\t\t\t" + getTime6(Array2) + "\r" +
				"20,000\t\t" + getTime(Array3) + "\t\t\t\t" + getTime2(Array3) + "\t\t\t\t" + getTime3(Array3) + "\t\t\t\t" + getTime4(Array3) + "\t\t\t\t" + getTime5(Array3) + "\t\t\t\t" + getTime6(Array3) + "\r" +
				"25,000\t\t" + getTime(Array4) + "\t\t\t\t" + getTime2(Array4) + "\t\t\t\t" + getTime3(Array4) + "\t\t\t\t" + getTime4(Array4) + "\t\t\t\t" + getTime5(Array4) + "\t\t\t\t" + getTime6(Array4) + "\r" +
				"30,000\t\t" + getTime(Array5) + "\t\t\t\t" + getTime2(Array5) + "\t\t\t\t" + getTime3(Array5) + "\t\t\t\t" + getTime4(Array5) + "\t\t\t\t" + getTime5(Array5) + "\t\t\t\t" + getTime6(Array5) + "\r" +
				"35,000\t\t" + getTime(Array6) + "\t\t\t\t" + getTime2(Array6) + "\t\t\t\t" + getTime3(Array6) + "\t\t\t\t" + getTime4(Array6) + "\t\t\t\t" + getTime5(Array6) + "\t\t\t\t" + getTime6(Array6) + "\r");


		BPane.setCenter(DisplayTxt);

		Scene scene = new Scene(BPane, 800, 300); //Set the scene
		primaryStage.setTitle("Time Sorting"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();

	}

	//Implements selection sort
	public static void selectionSort(int array[]){
		//Here
		for(int a = 0 ; a < array.length ; a++){
			array[a] = (1 + (int)(Math.random() * (600000 - 1 + 1)));
		}

		for(int i = 0 ;i < array.length ; i++){
			int smallNum = array[i];
			int position = i;
			for(int j=i+1;j < array.length;j++){
				if(array[j] < smallNum){
					smallNum = array[j];
					position = j;
				}
			}
			int temp = array[position];
			array[position] = array[i];
			array[i] = temp;
		}
	}



	//Implements insertion sort
	public static void insertionSort(int[] array){

		//Here
		for(int a = 0 ; a < array.length ; a++){
			array[a] = (1 + (int)(Math.random() * (600000 - 1 + 1)));
		}

		for (int a = 1; a < array.length; a++) {

			int Current = array[a]; 
			int b;

			for (b = a - 1; b >= 0 && array[b] > Current; b--) { 
				array[b + 1] = array[b];
			}
			array[b + 1] = Current;
		}
		System.out.println("Done.");
	}

	//Implements bubble sort
	public static void bubbleSort(int[] list){

		//Here
		for(int a = 0 ; a < list.length ; a++){
			list[a] = (1 + (int)(Math.random() * (600000 - 1 + 1)));
		}

		for(int i = 0 ; i < list.length ; i++){
			for(int j = i + 1 ; j < list.length ; j++){
				if((int)list[i] > (int)list[j]){
					int temp = list[j];
					list[j] = list[i];
					list[i] = temp;
				}
			}
		}
	}

	//Implements merge sort
	public static void mergeSort(int[] list) { 

		//Here
		for(int a = 0 ; a < list.length ; a++){
			list[a] = (1 + (int)(Math.random() * (600000 - 1 + 1)));
		}

		if (list.length > 1) { 
			int[] firstHalf = new int[list.length / 2]; 
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			mergeSort(firstHalf); 
			long secondHalfLength = list.length - list.length / 2; 
			int[] secondHalf = new int[(int) secondHalfLength]; 
			System.arraycopy(list, list.length / 2, secondHalf, 0, (int) secondHalfLength);
			mergeSort(secondHalf); 
			merge(firstHalf, secondHalf, list);
		} 
	}

	public static <E extends Comparable<E>> void merge(int[] FHalf, int[] SHalf, int[] list) {
		int present1 = 0;
		int present2 = 0; 
		int present3 = 0; 
		while (present1 < FHalf.length && present2 < SHalf.length) { 
			if ((int)FHalf[(int) present1] < (int)SHalf[(int) present2]) 
				list[(int) present3++] = FHalf[(int) present1++]; 
			else 
				list[(int) present3++] = SHalf[(int) present2++]; 
		} 
		while (present1 < FHalf.length)
			list[(int) present3++] = FHalf[(int) present1++]; 
		while (present2 < SHalf.length) 
			list[(int) present3++] = SHalf[(int) present2++]; 	
	} 

	public static void quickSortHelper(int[] list) {
		//Here
		for(int a = 0 ; a < list.length ; a++){
			list[a] = (1 + (int)(Math.random() * (600000 - 1 + 1)));
		}
		quickSort(list, 0, list.length - 1);
	}

	public static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}

	public static int partition(int[] list, int first, int last) {
		int switches = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search

		while (high > low) {
			// Search forward from left
			while (low <= high && list[low] <= switches)
				low++;

			// Search backward from right
			while (low <= high && list[high] > switches)
				high--;

			// Swap two elements in the list
			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while (high > first && list[high] >= switches)
			high--;

		// Swap pivot with list[high]
		if (switches > list[high]) {
			list[first] = list[high];
			list[high] = switches;
			return high;
		}
		else {
			return first;
		}
	}

	public static void heapSort(int[] array){
		Heap<Integer> ArrayL = new Heap<>();

		//Here

		for(int i = 0 ; i < array.length ; i++){
			ArrayL.add(array[i]);
		}

		for(int i = array.length - 1 ; i >= 0 ; i--){
			array[i] = ArrayL.remove();
		}
		
	}

	public static long getTime(int[] n) {

		long startTime = System.currentTimeMillis();

		selectionSort(n);

		long endTime = System.currentTimeMillis();

		return endTime - startTime;

	}

	public static long getTime2(int[] n) {

		long startTime = System.currentTimeMillis();

		insertionSort(n);

		long endTime = System.currentTimeMillis();

		return endTime - startTime;

	}

	public static long getTime3(int[] n) {

		long startTime = System.currentTimeMillis();

		bubbleSort(n);

		long endTime = System.currentTimeMillis();

		return endTime - startTime;

	}

	public static long getTime4(int[] n) {

		long startTime = System.currentTimeMillis();

		mergeSort(n);

		long endTime = System.currentTimeMillis();

		return endTime - startTime;

	}


	public static long getTime5(int[] n) {

		long startTime = System.currentTimeMillis();

		quickSortHelper(n);

		long endTime = System.currentTimeMillis();

		return endTime - startTime;

	}

	public static <E extends Comparable<E>> long getTime6(int[] n) {

		for(int a = 0 ; a < n.length ; a++){
			n[a] = (1 + (int)(Math.random() * (600000 - 1 + 1)));
		}

		long startTime = System.currentTimeMillis();

		heapSort(n);

		long endTime = System.currentTimeMillis();

		return endTime - startTime;

	}

	public static void main(String[] args) {
		launch(args);
	}

}
