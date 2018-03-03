package Homework2;

import java.io.PrintStream;
import java.util.Scanner;

public class ZipToBarcode
{
	static Scanner input = new Scanner(System.in);

	public void convert()
	{
		String[] Barcode = { "||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::", "|:|::" };
		for (;;)
		{
			System.out.print("Enter the 5 digit zip code: ");
			String zip = input.nextLine();

			String number = zip;
			int CheckAmount = Integer.parseInt(zip);
			if ((CheckAmount > 10001) && (CheckAmount < 99999))
			{
				String number1 = number.substring(0, 1);
				int value1 = Integer.parseInt(number1);
				String number2 = number.substring(1, 2);
				int value2 = Integer.parseInt(number2);
				String number3 = number.substring(2, 3);
				int value3 = Integer.parseInt(number3);
				String number4 = number.substring(3, 4);
				int value4 = Integer.parseInt(number4);
				String number5 = number.substring(4, 5);
				int value5 = Integer.parseInt(number5);

				int total = value1 + value2 + value3 + value4 + value5;

				int CheckDigit = CheckDigit(total);

				System.out.print(Barcode[value1] + Barcode[value2] + Barcode[value3] + Barcode[value4] + Barcode[value5]);

				System.out.print(Barcode[CheckDigit]);

				break;
			}
			System.out.println("The zip code entered is not 5 digits");
			System.out.println("Try Again");
		}
	}

	public int CheckDigit(int total)
	{
		int CheckDigit = Math.abs(total % 10);
		if (CheckDigit != 0) {
			if (CheckDigit != 0) {
				CheckDigit = Math.abs(CheckDigit - 10);
			}
		}
		System.out.println("The check digit number is: " + CheckDigit);

		return CheckDigit;
	}
}
