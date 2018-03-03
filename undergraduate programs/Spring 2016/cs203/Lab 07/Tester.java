package Lab;

public class Tester {

	public static void main(String[] args) {
		Integer [] IntArray = {45, 32, 56, 20, 46, 69, 420, 99, 150, 23, 37};
		
		BST <Integer> obj = new BST<Integer>(IntArray);

		System.out.println("The number of nodes in this AVL tree is: " + obj.getSize());
		
		//Returns the amount of leaves (parents with no grandchildren)
		System.out.print("The array list has ");
		obj.getNumberofLeaves();
		System.out.print("leaves.\r");
		
	
		//Returns the amount of leaves (parents with grandchildren)
		System.out.print("The array list has ");
		obj.getNumberofNonLeaves();
		System.out.print("non leaves.");
		System.out.println();
		System.out.print("Breadth first search: ");
		obj.breadthFirstTraversal();
		//obj.getNumberofNonLeaves();
	}

}
