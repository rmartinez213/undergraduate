import java.util.Scanner;
public class Lab6P1New {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		ProgramMenu();

	}
	public static void ProgramMenu(){
		Scanner input = new Scanner(System.in);
		System.out.println("Choose from the following menu: ");
		System.out.println("Choose a menu: ");
		System.out.print("1.Display Prime Palindromes\n" + "2.Display Mirrored Primes\n" +"3.Exit Program\n");
		System.out.print("Pick a menu(1-3): ");
		int menu = input.nextInt();

		System.out.println();
		do{
			if (menu == 1){
				System.out.print("How many palindromes to display?:");
				int a = input.nextInt();
				isOption1(a);
			}
			else if (menu == 2){
				System.out.print("How many mirrored primes to display?:");
				int a = input.nextInt();
				isOption2(a);
			}
			else if (menu == 3){
				System.out.print("Program will now close!");
				System.exit(1);
			}
			else{
				System.out.println("Wrong Input Try Again!");
			}
			System.out.print("1.Display Prime Palindromes\n" + "2.Display Mirrored Primes\n" +"3.Exit Program\n");
			System.out.print("Pick a menu(1~3): ");
			menu = input.nextInt();
		} while(menu <= 0 || menu >= 0);
	}

	public static int isOption1(int a){

		int PerLine = 10;
		int count = 0;
		int number = 2;
		while(count < a){
			if(isPrime(number)){
				if(isPalindrome(number) == number){

					String z = number + "";
					String last = z.substring(0,1);
					//int last = z.charAt(0);
					if(count <= 5){

						System.out.print(number + " " );
					}
					if(count > 5){
						System.out.print(number + last + " " );
					}

					count++;

					if(count % PerLine == 0){
						System.out.println();
					}
				}
			}
			number++;
		}
		return a;
	}

	public static int isOption2(int a){
		int PerLine = 10;
		int count = 0;
		int number = 2;
		while(count < a){
			if(isPrime(number)){
				String D = "" + number;
				int length = D.length();
				String Rework = "";
				for(int L = (length - 1); L >= 0 ; L--){
					char Number = D.charAt(L);
					Rework = Rework + Number;
				}
				int ReAgain = Integer.parseInt(Rework);
				if(isPrime(ReAgain) && (number != ReAgain)){
					System.out.print(D + " ");

					count++;
					if(count % PerLine == 0){
						System.out.println();
					}
				}

			}
			number++;
		}
		return a;
	}



	public static boolean isPrime(int a){
		for(int i = 2; i <= a / 2;i++){

			if(a % i == 0 ){
				return false;
			}

		}return true;

	}

	public static int isPalindrome(int a){
		String O = "" + a;
		int Length = O.length();
		String BReverse = "";

		for(int x = (Length - 1); x >= 0 ; x--){
			char Number = O.charAt(x);
			BReverse = BReverse + Number;
		}
		int Rework = Integer.parseInt(BReverse);
		if(a == Rework){
			return a;
		}
		return a;
	}
}