package Homework2;

import java.io.PrintStream;
import java.util.Scanner;

public class BarcodeToZip
{
	static Scanner input = new Scanner(System.in);

	public void convert2()
	{
		String[] PatternBarcode = { "||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::" };
		int[] NumberArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (;;)
		{
			System.out.print("Enter the barcode: ");
			String Barcode = input.nextLine();
			if (Barcode.length() == 30)
			{
				String Barcode1 = Barcode.substring(0, 5);
				String Barcode2 = Barcode.substring(5, 10);
				String Barcode3 = Barcode.substring(10, 15);
				String Barcode4 = Barcode.substring(15, 20);
				String Barcode5 = Barcode.substring(20, 25);
				String Barcode6 = Barcode.substring(25, 30);

				System.out.println();
				System.out.print("The zip code is: ");

				getZip(PatternBarcode, NumberArray, Barcode1, Barcode2, Barcode3, Barcode4, Barcode5, Barcode6);

				System.out.println();

				break;
			}
			System.out.println("You need to input 30 characters. You inputed: " + Barcode.length() + ". Try Again.");
		}
	}

	public void getZip(String[] patternBarcode, int[] numberArray, String Barcode1, String Barcode2, String Barcode3, String Barcode4, String Barcode5, String Barcode6)
	{
		int value = 0;
		for (int i = 0; i < patternBarcode.length; i++) {
			if (Barcode1.equals(patternBarcode[i])) {
				System.out.print(numberArray[i]);
			}
		}
		for (int i = 0; i < patternBarcode.length; i++) {
			if (Barcode2.equals(patternBarcode[i])) {
				System.out.print(numberArray[i]);
			}
		}
		for (int i = 0; i < patternBarcode.length; i++) {
			if (Barcode3.equals(patternBarcode[i])) {
				System.out.print(numberArray[i]);
			}
		}
		for (int i = 0; i < patternBarcode.length; i++) {
			if (Barcode4.equals(patternBarcode[i])) {
				System.out.print(numberArray[i]);
			}
		}
		for (int i = 0; i < patternBarcode.length; i++) {
			if (Barcode5.equals(patternBarcode[i])) {
				value += numberArray[i];
			}
		}
		for (int i = 0; i < patternBarcode.length; i++) {
			if (Barcode6.equals(patternBarcode[i])) {
				value += numberArray[i];
			}
		}
		System.out.print(value);
	}
}
