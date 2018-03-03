

import java.io.BufferedReader;
import java.io.FileReader;

public class Movies {

	public static void main(String[] args) {


		String [] movieArray = new String[4];
		String filename = "TvShows.txt";
		String[] s = new String[6];
		String[] l = new String[4];
		String Line = null;

		try{
			FileReader Freader = new FileReader(filename);
			BufferedReader Breader = new BufferedReader(Freader);
			while((Line = Breader.readLine()) != null){


				for(int i = 0, j = 0 ; i < movieArray.length ; i++, j++){
					
					movieArray[i] = s[j];
					
					//movieArray[i] = l[j];
				} 



				s = Line.split(" ");
				l = Line.split("\\r");
				//System.out.println(Line);
				//Depending on what number you put, it will print out that word
				//System.out.println(Line);
			}
		}catch(Exception e){
			System.out.println("Error " + e);
		}

		for(int i = 0 ; i < 2 ; i++){
			System.out.println("The TV show is " + movieArray[i] + " and Production house is " + movieArray[i + 1]);
			break;
		}


	}

}
