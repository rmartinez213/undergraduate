
public class Hw8P2 {

	public static void main(String[] args) {

		int[][] table;
		table = getArray();
		
		double[] PriceArr;
		PriceArr = priceArray();
		
		getPrintArray(table);
		getPrice(table, PriceArr);
		getPrice2(table, PriceArr);
		getPrice3(table, PriceArr);
		getPrice4(table, PriceArr);
	}

	public static int[][] getArray(){
		int[][] Array = {
				{10, 4, 5, 6, 7},
				{7, 0, 12, 1, 3},
				{4, 9, 5, 0, 8},
				{3, 2, 1, 5, 6}
		};
		return Array;
	}
	public static double[] priceArray(){
		double[] PriceArr = {10.95, 6.30, 14.74, 11.25, 5.00};
		return PriceArr;
	}
	
	public static void getPrintArray(int[][] table){
//		System.out.println("  Dev \t Component");
//		System.out.println();
		for(int row = 0 ; row < table.length ; row++){
			for(int col = 0 ; col < table[0].length ; col++){
				System.out.printf("%4d", table[row][col]);
			}
			System.out.println();
		}
	}

	public static void getPrice(int[][] table, double[] PriceArr){
		double price = 0;
		int count = 0;

		for(int col = 0, count1d = 0 ; col < table[0].length ; col++, count1d++){
			for(int row = 0 ; row < 1 ; row++){
//				System.out.print(table[row][col]);
				price += PriceArr[count1d] * table[row][col];
			}
		}
		System.out.println("Price for device 1 is: $" + price);
		System.out.printf("Total price of producing device 1 is: $%2.2f \n", price * .10);
	}
	
	public static void getPrice2(int[][] table, double[] PriceArr){
		double price = 0;
		int count = 0;

		for(int col = 0, count1d = 0 ; col < table[0].length ; col++, count1d++){
			for(int row = 1 ; row < 2 ; row++){
//				System.out.print(table[row][col]);
				price += PriceArr[count1d] * table[row][col];
			}
		}
		System.out.println("Price for device 2 is: $" + price);
		System.out.printf("Total price of producing device 2 is: $%2.2f \n", price * .10);
	}
	
	public static void getPrice3(int[][] table, double[] PriceArr){
		double price = 0;
		int count = 0;

		for(int col = 0, count1d = 0 ; col < table[0].length ; col++, count1d++){
			for(int row = 2 ; row < 3 ; row++){
//				System.out.print(table[row][col]);
				price += PriceArr[count1d] * table[row][col];
			}
		}
		System.out.println("Price for device 3 is: $" + price);
		System.out.printf("Total price of producing device 3 is: $%2.2f \n", price * .10);
	}
	
	public static void getPrice4(int[][] table, double[] PriceArr){
		double price = 0;
		int count = 0;

		for(int col = 0, count1d = 0 ; col < table[0].length ; col++, count1d++){
			for(int row = 3 ; row < 4 ; row++){
//				System.out.print(table[row][col]);
				price += PriceArr[count1d] * table[row][col];
			}
		}
		System.out.println("Price for device 4 is: $" + price);
		System.out.printf("Total price of producing device 4 is: $%2.2f \n", price * .10);
	}
	
}
