
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;


public class Lab3{

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		LinkedList<String> head = new LinkedList<>();
		ArrayList<String> ArrayL = new ArrayList<>();


				Problem2(head);
				Problem3(ArrayL);
				Problem5();
				Problem6();
				Problem7();
				//getTime(0);
	}

	public static void Problem2(LinkedList<String> head){

		System.out.print("How many words would you like to input into the LinkedList? ");
		int amount = input.nextInt();
		input.nextLine();

		for(int i = 0, k = 1 ; i < amount ; i++, k++){
			System.out.println("Enter your " + k + " number: " );
			String user = input.nextLine();
			head.add(user);
		}
		System.out.println(head.toString());
	}

	public static void Problem3(ArrayList<String> ArrayL){

		System.out.println();

		System.out.print("How many words would you like to input into the Array List? ");
		int amount = input.nextInt();
		input.nextLine();

		for(int i = 0, k = 1 ; i < amount ; i++, k++){
			System.out.println("You are in String " + k + ". Please enter your String: " );
			String user = input.nextLine();
			ArrayL.add(user);
		}

		for(int i = 0 ; i < ArrayL.size(); i++){
			for(int j = i + 1 ; j < ArrayL.size(); j++){

				if(ArrayL.get(i).equals(ArrayL.get(j))){
					ArrayL.remove(j);
					j = i;
				}
			}
		}

		//This big if statement sorts the array list in sequential

		if((ArrayL.size() - 1) != 0){
			for(int i = 0 ; i < ArrayL.size() - 1 ; i++){
				for(int j = i + 1 ; j < ArrayL.size() ; j++){
					if(ArrayL.get(i).compareTo(ArrayL.get(j)) > 0){

						String temp = ArrayL.get(i);

						ArrayL.set(i, ArrayL.get(j));

						ArrayL.set(j, temp);

					}
				}
			}
		}
		System.out.println(ArrayL.toString());
		System.out.println();
		Problem4(ArrayL);
	}

	public static void Problem4(ArrayList<String> arrayL){
		LinkedHashSet <String> HashArray = new LinkedHashSet<>();
		HashArray.addAll(arrayL);
		System.out.print("Here is the result of Problem 4: ");
		System.out.print(HashArray.toString());
	}

	public static void Problem5(){
		TreeSet<String> TreeArray = new TreeSet<>();
		String Filename = "Lincoln.txt";
		String[] StringArray = new String[0];
		String Line = null;

		try{
			FileReader FReader = new FileReader(Filename);
			BufferedReader BReader = new BufferedReader(FReader);
			while((Line = BReader.readLine()) != null){

				StringArray = Line.replaceAll("[, . -- ?]", " ").split("\\s");

				for(int i = 0 ; i < StringArray.length ; i++){
					//System.out.println(StringArray[i] + " " + StringArray[i + 1]);
					TreeArray.add(StringArray[i]);
				}
			}
			System.out.println(TreeArray.toString());
		}
		catch(Exception e){
			System.out.println("Error " + e);
		}
	}

	public static void Problem6(){
		TreeMap<String, Integer> TreeArray = new TreeMap<>();
		String Filename = "Lincoln.txt";
		String Line = null;
		int counter = 0;

		TreeArray.put("a", 0);
		TreeArray.put("e", 0);
		TreeArray.put("i", 0);
		TreeArray.put("I", 0);
		TreeArray.put("o", 0);
		TreeArray.put("u", 0);

		try{
			FileReader FReader = new FileReader(Filename);
			BufferedReader BReader = new BufferedReader(FReader);
			while((Line = BReader.readLine()) != null){	

				for(int i = 0 ; i < Line.length() ; i++){

					String vowels = Line.charAt(i) + "";

					if(TreeArray.containsKey(vowels)){
						int count = TreeArray.get(vowels);
						count++;
						TreeArray.put(vowels, count);
					}
				}
			}
			System.out.println(TreeArray.toString());
		}
		catch(Exception e){
			System.out.println("Error " + e);
		}
	}
	
	public static void Problem7(){
		TreeMap<String, Integer> TreeM = new TreeMap<>();
		ArrayList<String> ArrayL = new ArrayList<>();

		String Filename = "Lincoln.txt";
		String [] SArray;
		String Line = null;

		try{
			FileReader FReader = new FileReader(Filename);
			BufferedReader BReader = new BufferedReader(FReader);
			while((Line = BReader.readLine()) != null){	

				SArray = Line.replaceAll("[, . - ?]", " ").split(" ");

				for(int i = 0 ; i < SArray.length ; i++){
					ArrayL.add(SArray[i]);
					TreeM.put(SArray[i], 0);
				}
			}
			for(String e : ArrayL){
				if(TreeM.containsKey(e)){
					int count = TreeM.get(e);
					count++;
					TreeM.put(e, count);
				}
			}
		}
		catch(Exception e){
			System.out.println("Error " + e);
		}
		System.out.println(TreeM.toString());
	}
}
