

public class MaxSub {
	int Max_left;
	int Max_right;
	int Sum;

	public MaxSub(int Max_left, int Max_right, int Sum){
		this.Max_left = Max_left;
		this.Max_right = Max_right;
		this.Sum = Sum;
	}



	public int getMax_left() {
		return Max_left;
	}

	public void setMax_left(int max_left) {
		Max_left = max_left;
	}

	public int getMax_right() {
		return Max_right;
	}

	public void setMax_right(int max_right) {
		Max_right = max_right;
	}

	public int getSum() {
		return Sum;
	}

	public void setSum(int sum) {
		Sum = sum;
	}
}

