
public class Lab3{


	public static void main(String[] args) {
		int [] Array  = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		
		System.out.println("Stocks:");
		for(int i = 0; i < Array.length ; i++) {
			System.out.print(Array[i] + "\t");
		}
		
		System.out.println("\rDays:");
		
		for(int i = 0 ; i < Array.length ; i++) {
			System.out.print( i + 1 + "\t");
		}


		System.out.println("\r\rBrute Force Algorithm (n^2) ");
		System.out.println("_________________________________________________");
		BruteForce(Array);

		MaxSub MaxSubInput = SearchMaxSubArray(Array, 0, Array.length - 1);
		System.out.println("\r");
		System.out.println("Brute Force Algorithm Divide & Conquer (nlogn)");
		System.out.println("_________________________________________________");
		System.out.println("Max Left SubArray is: " + MaxSubInput.Max_left);
		System.out.println("Max Right SubArray is: " + MaxSubInput.Max_right);
		System.out.println("Max Sum is: " + MaxSubInput.Sum);
	}

	//Brute force method time complexity is n^2
	public static void BruteForce(int[] Array){

		/*We create these variable in order to
		keep track on which days we will buy and sell (get the most profit from the stocks)
		 */
		int Buy = 0;
		int Sell = 0;
		int MaxNumber = -10000000;

		for(int i = 0; i < Array.length ; i++){
			int sum = 0;
			for(int j = i ; j < Array.length ; j++){
				sum += Array[j];
				if(sum > MaxNumber){
					MaxNumber = sum;
					Buy = i;
					Sell = j;
				}
			}
		}
		//Add 1 because arrays start at 0 hence, the i
		System.out.print("The best day to buy stocks is on day: " + (Buy + 1) + "\rThe best day to sell stocks is on day: " + (Sell + 1) + "\rYou would earn a profit of: " + MaxNumber);
	}


	/*
	 Brute force algorithm can be made much more efficient with divide and conquer. 
	 Divide and conquer consist of 3 parts; the recursive method, implementation of finding the max left and right, ???.
	 Applying divide and conquer to Brute Force Algorithm will make the time efficiency go from ---> n^2 to nlogn. 
	 */


	//Divide and conquer consist of 3 parts. This is the first part, the recursive method
	public static MaxSub MaximumSubarray(int[] A, int low, int mid, int high){
		MaxSub MaxObj = new MaxSub(0, 0, 0);

		//Left SubArray Variables
		int LeftSum = -1000;
		int sum1 = 0;
		int maxLeft = 0;

		//First half of the 
		for(int i = mid ; i >= low ; i--){
			sum1 = sum1 + A[i];
			if(sum1 > LeftSum){
				LeftSum = sum1;
				maxLeft = i;
				MaxObj.Max_left = maxLeft;
			}
		}

		//Right SubArray Variables
		int RightSum = -1000;
		int sum2 = 0;
		int maxRight = 0;

		//Second half
		for(int j = mid + 1 ; j < high ; j++){
			sum2 = sum2 + A[j];
			if(sum2 > RightSum){
				RightSum = sum2;
				maxRight = j;
				MaxObj.Max_right = maxRight;
			}
		}

		MaxObj.Sum = (maxLeft + maxRight);
		return MaxObj;
	}

	//Second part of implementing divide and conquer
	public static MaxSub SearchMaxSubArray(int[] A, int low, int high){
		MaxSub SearchAndConquer = new MaxSub(low, high, A[low]);

		if(low == high)
			return SearchAndConquer;

		else{
			int mid = (low + high)/2;

			MaxSub LeftSide = SearchMaxSubArray(A, low, mid);

			MaxSub RightSide = SearchMaxSubArray(A, mid+1, high);

			MaxSub CrossLeftRight = MaximumSubarray(A, low, mid, high);

			if(LeftSide.Sum >= RightSide.Sum && LeftSide.Sum  >= CrossLeftRight.Sum){
				return LeftSide;
			}

			else if(RightSide.Sum >= LeftSide.Sum && RightSide.Sum >= CrossLeftRight.Sum){
				return RightSide;
			}
			else {
				return CrossLeftRight;
			}
		}

	}

}
