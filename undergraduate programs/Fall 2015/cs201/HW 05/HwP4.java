import java.util.Scanner;
public class HwP4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		final int BinToDec = 1;
		final int DecToBin = 2;
		final int Exit = 3;
		String UserDecAnswer = "";
		String text = "-----------------------------------------\n" +
				"|\tBinary Number Converter \t|\n" + "-----------------------------------------\n" +
				"| 1. Convert Binary To Decimal          |\n" + "| 2. Convert Decimal To Binary          |\n" + 
				"| 3. Exit The Program                   |\n" + "------------------------------------------\n" + "Enter your menu choice from (1 - 3): ";

		while(true){
			System.out.print(text);
			int user = input.nextInt();
			String binary;
			

			if (user == BinToDec){
				System.out.print("Enter the binary string:");
				binary = input.next();
				System.out.println();
				int m = binary.length()-1;
				int sum = 0;

				for(int n = m; n <= m && n >= 0;n--){
					char index = binary.charAt(n);
					if(index =='1'){
						int reverse = (m - n);
						sum += Math.pow(2, reverse);
					}	
				} System.out.println(binary + " = " + sum);
			}


			else if (user == DecToBin){
				System.out.print("Enter the decimal string:");
				int decimal = input.nextInt();
				String i = "";
				while (decimal > 0){
					int decimalReword = decimal % 2;
					decimal /= 2;
					i = decimalReword + i;
				}
				System.out.print(i);
			}

			else if ( user == Exit){
				System.out.print("System will exit!");
				System.exit(1);
			}
			else{
				System.out.println("Wrong input, try again!");
			}
			System.out.println();
		}
	}
}
