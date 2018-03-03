package Lab3;

public class DisplayOverloading {
	public int reverse(int numbers){
		int z = numbers;
		int number2 = 0;
		
		while(z != 0){
			number2 = number2 * 10 + z % 10;
			z /= 10;
			//System.out.print(number2);
		}
		System.out.println();
		return number2;
		
	}
	
	public String reverse(String word){
		int length = word.length();
		
		String back = "";
		for(int i = word.length() - 1 ; i  >= 0; i--){
			back += "" + word.charAt(i);
		}
		System.out.println(back);
		return back;
		
	}
}
