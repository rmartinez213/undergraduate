package Lab2;

import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

	static Scanner input = new Scanner(System.in);

	public static <E> void main(String[] args) {

		GenericStack obj =  new GenericStack();

		String[] list = {"Ice Cream", "Cheesecake", "Cupcake", "Brownie", "Chocolate" , "Cake", "Cake", "Cake", "CheeseCake", };
		
		//In this loop we add 
		for(int i = 0; i < list.length ; i++){
			obj.push(list[i]);
		}

		System.out.println("This has been removed: " + obj.pop());
		System.out.println("The number of elements in this ArrayList is: " + obj.getSize());
		System.out.println("Are there any elements in the array: " + obj.isEmpty());
		
		//Returns the index at of the key that matches the element
		System.out.println("Linear Search");
		System.out.print("What would you like your key to be? ");
		String key = input.nextLine();
		
		
		System.out.println("Linear Search (Index starts at 1): " + (GenericStack.linearSearch(list, key)));
		
		/**Returns the index of the key that matches the element 
		 * (if element is not their, it returns the index of where it will go) */
		
		System.out.println("Binary Search");
		System.out.print("What would you like your key to be? ");
		String key2 = input.nextLine();
		
		System.out.println("Binary Search (Index starts at 1): " + (GenericStack.binarySearch(list, key2)));
		
		//Returns the sorted Array
		System.out.println("Selection Sort");
		GenericStack.selectionSort(list);

		System.out.println();
		System.out.println();
		System.out.println("Extra Credit");
		
		String[][] MaxArray = {
				{"Peanuts", "Shakes", "Cheesecake"},
				{"Chocolate Cake", "Red Velvet", "BlueBerry Cake"},
				{"White Chocolate", "Milk Chocolate", "Dark Chocolate"}
				};

		ArrayList<String> arrayL = new ArrayList<String>();
	
		//Adds the values from the push method from GenericStack Class.
		arrayL.addAll(obj);
		
		//Removes duplicated elements in the array list
		System.out.println("Removes the duplicates from an Array List: " + obj.removeDuplicates(arrayL));
		
		//Returns the max 2D Array
		System.out.println("Here is your max from  a 2D Array: " + obj.max(MaxArray));
		
		//Returns a sorted ArrayList
		obj.sort(arrayL);
		
		//Returns a shuffled ArrayList
		System.out.print("Here is your shuffled array list: ");
		obj.suffle(arrayL);

	}


}
