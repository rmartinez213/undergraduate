import java.util.Scanner;
public class Hw8P3 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Enter the number of rows and columns: ");
		int matrix = input.nextInt();

		System.out.print("Enter the first value of the table: ");
		int Start = input.nextInt();

		System.out.print("Enter the increment value: ");
		int Add = input.nextInt();

		int[][] table = new int [matrix][matrix];
		table = getMatrix(table,Start, Add);

		MajorMinor(table);
	}

	public static int[][] getMatrix(int[][] array,int start,int add){
		array[0][0] = start;
		int sum = start - add;
		System.out.println("Matrix:");
		System.out.println();
		for(int a = 0; a < array.length;a++){
			for(int b=  0 ; b < array[0].length;b++){
				sum += add;	
				array[a][b] = sum;	
			}
		}
		
		for(int a = 0 ; a < array.length;a++){
			for(int b = 0 ; b < array[0].length ; b++){
				System.out.printf("%4d", array[a][b]);
			}
			System.out.println();
		}
		return(array);

	}
	
	public static void MajorMinor(int[][] array){
		int[] MajorDiagnol;
		MajorDiagnol = new int[array.length];
		int[] MinorDiagnol;
		MinorDiagnol = new int[array.length];
		int count = 0;
		
		//Gets diagnols and stores into copy array [Major]
		for(int row = 0, col = 0 ; row < array.length && col < array[0].length; row++, col++, count++){
			int temp = array[row][col];
			MajorDiagnol[row] = temp;
		}
		
		//Original ray is being replaced with copy array[Major]
		for(int t = 0,u = 0, NewCount = count - 1; NewCount >= 0; t++,	u++, NewCount--){
			array[t][u] = MajorDiagnol[NewCount];

		}
		
		//Gets diagonols and stores into copy array [Minor]
		int z = array[0].length -1;
		int counter = 0;

		for(int y = 0 ; y < array.length && z >= 0; y++, z--, counter++){
			int temp =array[y][z];
			MinorDiagnol[counter] = temp;
		}

		//Original ray is being replaced with copy array [Minor]
		int col = array[0].length -1; 
		for(int row = 0, NewCounter = counter - 1; NewCounter >= 0; row++, col--, NewCounter--){
			array[row][col] = MinorDiagnol[NewCounter];
		}
		
		System.out.println();
		System.out.println("Flipped Diagonals:");
		System.out.println();
		for(int r = 0 ; r < array.length ; r++){
			for( int c = 0 ; c < array[0].length ; c++){
				System.out.printf("%4d",array[r][c]);
			}
			System.out.println();
		}
		diagonal(array);

		PrintMagicMatrix(array,row(array),Column(array), diagonal(array));
	}


	public static int[] row(int[][] array){
		int[] row;
		row = new int[array.length];
		int total = 0;
		for(int r = 0 ; r < array.length;r++){ 
			total = 0;
			for(int c = 0 ; c < array[0].length ; c++){
				total += array[r][c];
			}
			row[r] = total;		
		}
		return row;
	}


	public static int[] Column(int[][] array){
		int[] col;
		col = new int[array.length];
		
		for(int c = 0, total = 0 ; c < array[0].length ; c++){ 
			total = 0;
			for(int r = 0 ; r <array.length ; r++){
				total += array[r][c];
			}
			col[c] = total;		
		}
		return col;
	}

	public static int[] diagonal(int[][]array){
		int[] DArray = new int[2];
		int x = 0;
		int sum = 0;
		for(int y = 0 ; x < array.length && y < array[0].length;){
			sum +=array[x][y];
			DArray[0] = sum;
			x++;
			y++; 	
		}
		int placer = array[0].length -1;
		for(int y = 0 , sum1 = 0 ; y < array.length && placer >= 0 ; y++, placer--){
			sum1 += array[y][placer];
			DArray[1] = sum1;			
		}

		return DArray;
	}



	//This method prints the last matrix
	public static void PrintMagicMatrix(int[][] array,int[]rows,int[] col,int[] diag_array){
		int sum = 0;
		for(int r = 0 ; r < array.length ; r++){
			for(int c = 0 ; c < array[0].length ; c++){
				sum += array[r][c];
			}
		}
		int MagicNumber = sum/array.length;
		System.out.println();
		System.out.println("Magic Number:" + MagicNumber);

		
		for(int a = 0;a < col.length;a++){
			System.out.print("    ");		
		}
		System.out.println(" | " + diag_array[0]);
		for(int a = 0;a < col.length;a++){
			System.out.print("------");		
		}
		
		System.out.println();
		
		//This loop prints the whole table
		for(int a = 0 ; a < array.length;a++){ 
			for(int b =0 ; b < array[0].length;b++){
				System.out.printf("%4d", array[a][b]);
			}
			System.out.printf(" | " + rows[a]);
			System.out.println();
		}

		//This loop prints the hyphens with diaganol total
		for(int a = 0;a < col.length;a++){
			System.out.print("------");		
		}
		System.out.println();

		//This prints the column total addition
		for(int a =0;a < col.length;a++){
			System.out.printf("%4d",col[a]);			
		}
		System.out.printf(" |%4d \n", diag_array[1]);

		System.out.println();
		for(int r = 0 ; r < rows.length ; r++){
			for(int c = 0 ; c < col.length ; c++){
				if(MagicNumber == diag_array[0] && MagicNumber == diag_array[1] && MagicNumber == rows[r] && MagicNumber == col[c]){
					System.out.print("YES this is a magic number matrix");
					break;
				}
				else if(MagicNumber != diag_array[1] || MagicNumber != rows[r] || MagicNumber != col[c]){
					System.out.print("NO this is a not a magic matrix");
					break;
				}
				
			}
			break;
		}
	}
}
