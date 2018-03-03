package Lab2;

import java.lang.reflect.Array;
import java.util.*;



public class GenericStack<E> extends ArrayList<E>{

	static Scanner input = new Scanner(System.in);


	/** Push a new element into the top of the stack */

	public void push(E value) {

		add(value);
		System.out.println(value);
	}



	/** Return and remove the top element from the stack */

	public E pop() {

		E temp = get(size() - 1);

		remove(get(size() - 1));

		return temp;

	}


	//First element in the stack, print it out 
	/** Return the top element from the stack */

	public E peek() {

		E peek = get(size() - 1);

		return peek;
	}



	/** Exercise03_21 whether the stack is empty */

	public boolean isEmpty() {

		if((size() - 1) >= 0){
			return true;
		}
		else{
			return false;
		}
	}



	/** Return the number of elements in the stack */

	public int getSize() {

		int size = size();
		return size;

	}

	public static <E extends Comparable<E>> int linearSearch(E[] list, E key){


		for(int i = 0; i < list.length - 1 ; i++){
			if(key.equals(list[i]))
				return i + 1;
		}

		return -1;
	}


	public static <E extends Comparable<E>> int binarySearch(E[] list, E key){

		for(int i = 0 ; i < list.length - 1; i++){
			for(int j = i + 1 ; j < list.length - 1; j++){
				if(list[i].compareTo(list[j]) > 0){
					E temp = list[j];
					list[j] = list[i];
					list[i] = temp;
				}
			}
		}

		int LValue = 0;
		int HValue = list.length - 1;
		int MValue = 0;

		while(HValue >= LValue){
			MValue = (LValue + HValue) / 2;

			if(key.compareTo(list[MValue]) == 0){
				return MValue;
			}
			else if(key.compareTo(list[MValue]) < 0){
				HValue = MValue - 1;
			}
			else if(key.compareTo(list[MValue]) > 0){
				LValue = MValue + 1;
			}
		}

		return LValue -1;
	}

	public static<E extends Comparable<E>> void selectionSort(E[] list){
		for(int i = 0 ; i < list.length - 1; i++){
			for(int j = i + 1 ; j < list.length - 1; j++){
				if(list[i].compareTo(list[j]) > 0){
					E temp = list[j];
					list[j] = list[i];
					list[i] = temp;
				}
			}
		}

		System.out.print("Here is your sorted method: ");
		for(int i = 0 ; i < list.length - 1; i++){
			System.out.print(list[i] + " ");
		}
	}

	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){

		for(int i = 0 ; i < list.size(); i++){
			for(int j = i + 1 ; j < list.size(); j++){

				if(list.get(i).equals(list.get(j))){
					list.remove(j);
					j = i;
				}
			}
		}

		return list;
	}

	public static <E extends Comparable<E>> E max(E[][] list){

		E Max = list[0][0];

		for(int row = 0; row < list.length ; row++){
			for(int col = 0 ; col < list[row].length ;col++){
				if(list[row][col].compareTo(Max) > 0){
					Max = list[row][col];	
				}
			}	
		}
		return Max;
	}

	public static <E extends Comparable<E>> void sort(ArrayList<E> arrayL){


		if((arrayL.size() - 1) != 0){
			for(int i = 0 ; i < arrayL.size() - 1 ; i++){
				for(int j = i + 1 ; j < arrayL.size() ; j++){
					if(arrayL.get(i).compareTo(arrayL.get(j)) > 0){

						E temp = arrayL.get(i);

						arrayL.set(i, arrayL.get(j));

						arrayL.set(j, temp);

					}
				}
			}

			System.out.print("Here is your sorted method: [ ");
			for(int i = 0 ; i < arrayL.size(); i++){
				System.out.print(arrayL.get(i) + " ");	
			}
			System.out.print("]");
		}
		System.out.println();
	}

	public static <E > void suffle(ArrayList<E> list){
		E temp;

		
		//For loop that shuffles the elements in different indexs
		for(int i = 0; i < list.size(); i++){
			int random = (int) (Math.random() * (list.size() - 1) + 1);		
			temp = list.get(i);
			list.set(i, list.get(random));
			list.set(random, temp);
		}
		
		System.out.print("[ ");
		for(int i = 0 ; i < list.size() ; i++){
			System.out.print(list.get(i) + " ");
		}
		System.out.print("]");
	}
}
