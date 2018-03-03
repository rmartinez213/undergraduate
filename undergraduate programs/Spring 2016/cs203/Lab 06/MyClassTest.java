package Lab;

import java.util.Scanner;

public class MyClassTest<E> {

	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws InterruptedException {
		MyClass<String> Obj = new MyClass<>();

		while(true){
			System.out.println("----------Menu----------");
			System.out.println("(1) Add an element into the linked list.\r"
					+ "(2) Delete an element from a linked list \r" + "(3) Check to see if it contains something.\r" 
					+ "(4) Get the element at a certain index.\r" + "(5) Get the index of an element.\r"
					+ "(6) Check to see if linked list is empty.\r" + "(7) Get the number of elements in the linked list.\r"
					+ "(8) Replace an element at a specified position.\r" + "(9) Clear the linked list.\r"
					+ "(10) Close application");
			System.out.println();
			int user = input.nextInt();

			switch(user){
			case 1: 
				System.out.println("(1) - At the end of the array\r(2) - specific index");
				int userAdd = input.nextInt();

				if(userAdd == 1){
					input.nextLine();
					System.out.println("Enter the element you want in the linked list(end): ");
					String userInput = input.nextLine();
					Obj.add(userInput); 
				}

				if(userAdd == 2){
					input.nextLine();
					System.out.println("Enter the element you want in the linked list: ");
					String userInput = input.nextLine();
					System.out.println("At what index? ");
					int index = input.nextInt();
					Obj.add(index, userInput); 
				}
				break;

			case 2: 
				input.nextLine();
				System.out.println("What index would you like to remove? ");
				int userRemove = input.nextInt();
				System.out.println("You deleted " + Obj.remove(userRemove) + " successfully.");		
				break;
				
			case 3:	
				input.nextLine();
				System.out.println("What do you want to see if the linked list contains? ");
				String userContains = input.nextLine();
				System.out.println(Obj.contains(userContains));
				break;
				
			case 4: 
				input.nextLine();
				System.out.println("Type the index that you want: ");
				int userIndex = input.nextInt();
				System.out.println(Obj.get(userIndex));
				break;
			
			case 5: 
				input.nextLine();
				System.out.println("Enter the element you want to find the index of: ");
				String userIndexof = input.nextLine();
				System.out.println(Obj.indexOf(userIndexof));
				break;
				
			case 6:
				input.nextLine();
				if(Obj.isEmpty())
					System.out.println("The linked list is EMPTY!");
				
				else
					System.out.println("There linked list is NOT EMPTY!");
				break;
			
			case 7: 
				input.nextLine();
				if(Obj.size() == 0){
					System.out.println("The size of the elements in the linked list is: " + 0);
				}
				else if(Obj.size() >= 1){
					System.out.println("The size of the elements in the linked list is: " + Obj.size());
				}
				break;
				
			case 8:
				input.nextLine();
				System.out.println("What index would you like to replace? ");
				int userIndexReplace = input.nextInt();
				input.nextLine();
				System.out.println("What element would you like to put into that index? ");
				String userElementReplace = input.nextLine();
				
				Obj.set(userIndexReplace, userElementReplace);
				break;
			
			case 9:
				Obj.clear();
				break;
				
			case 10: 
				System.out.print("\rThe program is shutting down.");
				Thread.sleep(750);
				System.out.print(".");
				Thread.sleep(750);
				System.out.print(".\r");
				Thread.sleep(1000);
				System.out.println("Program shutdown complete.");
				System.exit(0);
			}
		}
	}

}
