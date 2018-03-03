package Lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class CoffeeShop {



	public void fileReader(){

		Scanner input = new Scanner(System.in);
		System.out.print("What zip code would you like to drink coffee? ");

		String zip = input.nextLine();

		String[] zipArray = new String[4];

		String filename = "zipcode.txt";
		String[] s = new String[10];
		String Line = null;

		try{
			FileReader Freader = new FileReader(filename);
			BufferedReader Breader = new BufferedReader(Freader);
			while((Line = Breader.readLine()) != null){


				if(zip.equals(s[5])){
					for(int i = 0, j = 2 ; i < zipArray.length ; i++, ++j){
						zipArray[i] = s[j];
					} 
				}
				
				//Phone number, adress, city, zipcode


				s = Line.split("\\t");
				//Depending on what number you put, it will print out that word
				//System.out.println(Line);
			}
		}catch(Exception e){
			System.out.println("Error " + e);
		}

		for(int i = 0 ; i <= 3 ; i++){
			System.out.println("Phone Number: " + zipArray[i]);
			i++;
			System.out.println("Address: " + zipArray[i]);
			i++;
			System.out.println("City: " + zipArray[i]);
			i++;
			System.out.println("Zip Code: " + zipArray[i]);
		}
		
	}


}
