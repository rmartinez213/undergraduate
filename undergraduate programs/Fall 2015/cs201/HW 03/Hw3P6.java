public class Hw3P6{
	public static void main(String[] args){

		int value1 = (1 + (int)(Math.random() * (13 - 1 +1)));
		int suits = (15 + (int)(Math.random() * (18 - 15 + 1)));

		System.out.print("The card you picked is ");
		switch (value1){
		case 1: System.out.print("Ace");
		break;
		case 2: System.out.print("Two");
		break;
		case 3: System.out.print("Three");
		break;
		case 4: System.out.print("Four");
		break;
		case 5: System.out.print("Five");
		break;
		case 6: System.out.print("Six");
		break;
		case 7: System.out.print("Seven");
		break;
		case 8: System.out.print("Eight");
		break;
		case 9: System.out.print("Nine");
		break;
		case 10: System.out.print("Ten");
		break;
		case 11: System.out.print("Jack");
		break;
		case 12: System.out.print("Queen");
		break;
		case 13: System.out.print("King");
		break;
		}
		System.out.print(" of ");

		switch (suits){
		case 15: System.out.print("Hearts.");
		break;
		case 16: System.out.print("Diamonds.");
		break;
		case 17: System.out.print("Clubs.");
		break;
		case 18: System.out.print("Spades.");
		}
	}
}