import java.util.Scanner;
public class Hw7P6 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("How many types of cookies were produced? ");
		int TypesOf = input.nextInt();
		input.nextLine();

		PrintAll(getCookies(TypesOf), TypesOf);
	}

	public static void PrintAll(String[] Names, int TypesOf){
		PrintWeekly(getAmount(Names, TypesOf), TypesOf, Names);
	}

	public static String[] getCookies(int TypesOf){
		//This gets the name of the cookies that user inputs
		String [] Names = new String [TypesOf];
		System.out.println("Enter the names of the cookies one per line: ");
		for(int x = 0 ; x < TypesOf ; x++){
			Names [x] = input.nextLine();
		}

		return Names;
	}

	public static int [] getAmount(String[] names, int TypesOf){
		//This asks the user for the amount of weekly packages sold
		int [] AmountSold = new int[TypesOf];

		for( int x = 0 ; x < TypesOf ; x++){
			System.out.print("How many packages " + names[x] + " were sold this week: ");
			AmountSold[x] = input.nextInt();
		}

		return AmountSold;
	}


	public static void PrintWeekly(int[] AmountSold, int TypesOf, String[] Names){


		//This Calculates The Max Sold
		double Max = AmountSold[0];
		String MaxName = "";
		for(int z = 1 ; z < AmountSold.length ; z++){
			if(AmountSold[z] > Max){
				MaxName = Names[z];
				Max = AmountSold[z];
			}
		}

		//This calculates the Least amount sold
		double least = AmountSold[0];
		String LeastName = "";
		for(int z = 1 ; z < AmountSold.length ; z++){
			if(AmountSold[z] < least){
				LeastName = Names[z];
				least = AmountSold[z];
			}
		}
		System.out.println();

		String Padding = "";
		String Dash = "";
		String Dash2 = "";
		//Format Strings to get the length
		String Format = String.format("Highest Sold: %-15s %s\n", Padding, MaxName);
		String Format2 = String.format("Lowest Sold:  %-15s %s\n", Padding, LeastName);
		double Length = Format.length();
		double Length2 = Format2.length();
		double LengthFinal = 0;

		//Determine if Highest Sold or Lowest Sold has higher indexs
		if(Length > Length2){
			LengthFinal = Length;
		}
		else if(Length2 > Length){
			LengthFinal = Length2;
		}
		else{
			LengthFinal = Length;
		}
		//Determines how many dashes to print
		for(int i = 0 ; i < LengthFinal - 1; i++){
			Dash += "-";
		}
		//Determines how many dashes to print out in the Weekly Sales Report Header
		for(int i = 0 ; i < Math.floor((LengthFinal - 19) / 2) ; i++){
			Dash2 += "-";
		}
		System.out.print(Dash2 + "Weekly Sales Report" + Dash2 + "\n");



		String Type = "Type";
		String Pack = "Num Packages Sold";

		System.out.printf("%-29s %s\n", Type, Pack);

		System.out.println(Dash);

		//This prints out brand and total sold but also calculates the total amount sold
		//Also Alphabetizes

		int count = 0;

		for(int x = 0; x < AmountSold.length; x++){
			for(int y = x + 1; y < AmountSold.length; y++){

				if(Names[x].compareToIgnoreCase(Names[y])>0){
					String temp = Names[x];		
					int temp1 = AmountSold[x];
					Names[x] = Names[y];
					AmountSold[x] = AmountSold[y];

					Names[y] = temp;
					AmountSold[y] = temp1; 
				}
			}	

			System.out.printf("%-29s %s\n",Names[x], AmountSold[x]);
			count += AmountSold[x];
		}

		String SCount = count + "";


		System.out.println(Dash);
		System.out.printf("Total Sold: %-17s %s\n", Padding, SCount );
		System.out.println(Dash);
		System.out.print(Format);
		System.out.print(Format2);
		System.out.println(Dash);

	}
}
