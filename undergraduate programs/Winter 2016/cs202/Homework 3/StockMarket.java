package Homework3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StockMarket
{
	static Scanner input = new Scanner(System.in);

	public void menu()
	{
		ArrayList<StockPrice> StockArray = new ArrayList();

		int count = 0;
		for (;;)
		{
			System.out.println("\t \tMenu \n - - - - - - - - - - - - - - - - -\n|  (1) Parse Data  \t\t | \n|  (2) Add StockPrice Object  \t | \n|  (3) Delete StockPrice Object  | \n|  (4) Save Stock  \t\t | \n|  (5) Show Stock Prices \t | \n|  (6) Close Program  \t\t | \n - - - - - - - - - - - - - - - - -");

			System.out.print("Choose a number: ");
			int UserInput = input.nextInt();
			if (UserInput == 1)
			{
				if (count == 0)
				{
					count++;
					ParseFiles(StockArray);
					System.out.println("You Successfully Parsed the Information!");
				}
				else if (count != 0)
				{
					System.out.println("You already Parsed the information.");
				}
			}
			else if (UserInput == 2)
			{
				CreateStock(StockArray);
			}
			else if (UserInput == 3)
			{
				DeleteStock(StockArray);
			}
			else if (UserInput == 4)
			{
				SaveStock(StockArray);
			}
			else if (UserInput == 5)
			{
				ShowStock(StockArray);
			}
			else if (UserInput == 6)
			{
				System.out.println("This program will now close. Thank you.");
				System.exit(1);
			}
			else
			{
				System.out.println("Number does not match menu. Try Again.");
			}
		}
	}

	public void ParseFiles(ArrayList<StockPrice> stockArray)
	{
		String filename = "NewStock.csv";
		String Line = null;

		String[] stock = new String[20];
		try
		{
			FileReader Freader = new FileReader(filename);
			BufferedReader Breader = new BufferedReader(Freader);
			while ((Line = Breader.readLine()) != null)
			{
				stock = Line.split(",");

				String date = stock[0];

				String name = stock[1];

				double open = Double.parseDouble(stock[2]);

				double close = Double.parseDouble(stock[3]);

				stockArray.add(new StockPrice(date, name, open, close));
			}
		}
		catch (Exception e)
		{
			System.out.println("Error" + e);
		}
	}

	public void CreateStock(ArrayList<StockPrice> stockArray)
	{
		System.out.println("Enter date in the following format(03/10/1993): ");
		input.nextLine();
		String Date = input.nextLine();

		System.out.println("Enter name of the company(DOLP): ");
		String Name = input.nextLine();

		System.out.println("Enter the opening price: ");
		double Open = input.nextDouble();

		System.out.println("Enter the closing price: ");
		double Close = input.nextDouble();

		stockArray.add(new StockPrice(Date, Name, Open, Close));

		System.out.println("You successfully added a new stock!");
	}

	private void DeleteStock(ArrayList<StockPrice> stockArray)
	{
		int counter = 0;

		System.out.println("Enter the name of the company you would like to delete");
		input.nextLine();
		String UserName = input.nextLine();
		for (StockPrice x : stockArray) {
			counter++;
		}
		int count = 0;
		int DelOrNo = 0;
		if (counter == 0)
		{
			System.out.println("There are no stocks.");
		}
		else
		{
			for (StockPrice a : stockArray)
			{
				if (UserName.equals(a.getName()))
				{
					System.out.println("You Successfully deleted the stock!");
					break;
				}
				if (count + 1 == stockArray.size())
				{
					System.out.println("There are no matches to that company name.");
					DelOrNo++;
					break;
				}
				count++;
			}
			if (DelOrNo == 0) {
				stockArray.remove(count);
			}
		}
	}

	public void SaveStock(ArrayList<StockPrice> stockArray)
	{
		String filename = "NewStock.csv";
		String Line = null;
		try
		{
			FileWriter Fwrite = new FileWriter(filename);
			BufferedWriter Bwrite = new BufferedWriter(Fwrite);
			for (StockPrice x : stockArray)
			{
				Bwrite.write(x.getMonth() + "/" + x.getDay() + "/" + x.getYear() + "," + x.getName() + "," + x.getOpen() + "," + x.getClose());
				Bwrite.newLine();
			}
			Bwrite.close();
		}
		catch (Exception e)
		{
			System.out.println("Error" + e);
		}
		if (stockArray.size() == 0) {
			System.out.println("There is no information to be written.");
		} else if (stockArray.size() != 0) {
			System.out.println("The information was Successfully saved into CSV.");
		}
	}

	public void ShowStock(ArrayList<StockPrice> stockArray)
	{
		if (stockArray.size() == 0) {
			System.out.println("There are no stocks to show!");
		} else {
			for (StockPrice x : stockArray) {
				System.out.println(x);
			}
		}
	}
}
