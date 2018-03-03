package Lab;

public class AVLTest {

	public static void main(String[] args) {
		Integer [] IntArray = {45, 32, 56, 20, 46, 69, 420, 99, 150, 23, 37};

		AVLTree <Integer> obj = new AVLTree<Integer>(IntArray);
		System.out.print("The smallest K number is: ");
		obj.find(45);
		

	}

}
