
public class Lab5P2 {

	public static void main(String[] args) {

		int numDivisible = 1;
		int modul =1;

		for(int i = 1; i < 10000; i++){

			int sum = 0;

			int j;

			for( j =1; j < i; j++){
				
				if(i%j == 0){
					sum += j;

					modul +=j;

				}
			}
			if (sum == i){

				System.out.print(sum);
				System.out.println(" = " + i/3 * 2  + " + " + i/3 + " + " + j/i);
			}
		}
	}
}