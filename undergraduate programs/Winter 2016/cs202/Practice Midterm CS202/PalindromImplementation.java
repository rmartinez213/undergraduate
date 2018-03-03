
public class PalindromImplementation extends PalindromeInput{

	public void PalindormeMethod(){


		int count = 0;

		for(int j = 0 ; j < 9 ; j++){
			if( palIntegerInput % 10 == j ){
				count++;
			}

			if( (palIntegerInput / 100) % 10 == j){
				count++;
			}

			if( palIntegerInput / 10 % 10 == j){
				count++;
			}

			if( palIntegerInput / 1000 == j){
				count++;
			}

		}

		String getPalStringInput = palIntegerInput + "";

		if(getPalStringInput.length() == count){
			System.out.println(getPalStringInput + " is a palindrome");

		}

		else if (getPalStringInput.length() != count){
			System.out.println(getPalStringInput+ " is NOT a palindrome");
		}
	}
}