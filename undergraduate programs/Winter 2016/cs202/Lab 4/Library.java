package Lab4;

import java.util.ArrayList;

public class Library implements LibraryBooks, LibraryMovies{
	

	
	@Override
	public void DisplayMovies() {
		
		ArrayList <String> Movies = new ArrayList<String>();
		
		System.out.println("The movies are: ");
		Movies.add(("The Pink Panther"));
		Movies.add(("Black Panther"));
		Movies.add(("Wolverine"));
		Movies.add(("Inception"));
		Movies.add(("Concussion"));
		
		
		for(String x : Movies){
			System.out.println(x);
		}
		
		System.out.println();
	}

	@Override
	public void DisplayBooks() {
		
		ArrayList <String> Movies = new ArrayList<String>();

		System.out.println("The books are: ");
		
		Movies.add(("The Great Gastby"));
		Movies.add(("Black Boy"));
		Movies.add(("50 Shades of Gray"));
		Movies.add(("Hell Boy"));
		Movies.add(("The Witcher"));
		
		for(String x : Movies){
			System.out.println(x);
		}
		System.out.println();
		
	}


}
