import java.util.Scanner;
public class Hw7P2 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the amount of elements: ");
		int Indexs = input.nextInt();

		printAll(RandomValues(Indexs));
	}

	public static int [] RandomValues(int elements){
		int[] array = new int [elements];


		for( int a = 0 ; a < elements ; a++){
			array[a] = 1 + (int)(Math.random() * (20 - 1 + 1));
		}
		return array;
	}

	public static void printAll(int [] array){
		System.out.println();

		Array(array);
		OddIndexs(array);
		EvenElements(array);
		reverse(array);
		FML(array);
	}

	public static void Array(int [] array){
		System.out.print("Array: \t\t\t");
		for(int x = 0 ; x < array.length ; x++){
			System.out.print(array[x] + " ");
		}
	}

	public static void OddIndexs(int [] array){
		System.out.println();
		System.out.print("Odd Indexes: \t\t");
		for (int x = 1 ; x < array.length ;){
			System.out.print(array[x] + " ");
			x += 2;
		}
	}

	public static void EvenElements(int [] array){
		System.out.println();
		System.out.print("Even Elements: \t\t");
		for(int x = 0 ; x < array.length ; x++){
			if(array[x] % 2 == 0){
				System.out.print(array[x] + " ");
			}
		}
	}

	public static void reverse(int [] array){
		System.out.println();
		System.out.print("Reverse: \t\t");
		int CountDown = array.length - 1;
		for( ; CountDown >= 0 ; CountDown--){
			System.out.print(array[CountDown] + " ");
		}
	}
	public static void FML(int [] array){
		System.out.println();
		System.out.print("First, Middle, Last: \t");

		for(int x = 0 ; x < array.length ; x++){
			if(x == 0){
				System.out.print(array[x] + " ");
			}
			else if (x  == (array.length / 2)){
				System.out.print(array[x] + " ");
			}
			else if (x  == ((array.length - 1) / 2)){
				System.out.print(array[x] + " ");
			}
			else if(x == array.length - 1){
				System.out.print(array[x] + " ");
			}
		}
	}

}
