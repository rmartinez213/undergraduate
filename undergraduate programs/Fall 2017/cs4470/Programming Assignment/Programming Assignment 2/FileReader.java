package ProgrammingAssignment2Final;
import java.io.File; 
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class FileReader {
	public static Scanner sc = new Scanner(System.in);
	public static String myFile;
	public static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args){
		System.out.println("Where's the file?");
		myFile = sc.nextLine();
		readFile();


	}


	public static void readFile(){

		try{

			File inFile = new File(myFile);
			Scanner freader = new Scanner (inFile);

			String line;
			String[] field;

			while(freader.hasNextLine()){
				line = freader.nextLine();
				field = line.split(" ");

				list.add(line);

			}
			freader.close();


		}catch(IOException e){
			System.err.println(e);
			System.exit(1);

		}

	}
	public static ArrayList<String> getList(){
		return list;
	}
}
