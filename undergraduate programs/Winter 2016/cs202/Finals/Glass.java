

public class Glass extends Vessel{

	public double volume;

	public Glass(double a){
		this.volume = volume;
	}

	final double pi = Math.PI;
	final double RadiusOfBase = 4;
	double height = 4.5;

	@Override
	public double getCurrentContentsInCC() {
		System.out.println("Youre current contents in CC is: " + volume + "ml");
		return volume;
	}

	@Override
	public double getCapacityInCC() {
		double Volume = pi * Math.pow(RadiusOfBase, 2) * height;
		System.out.println("The volume in the glass is: " + Volume);
		return Volume;
	}

	@Override
	public double pourIn(double amount) {
		double pour = 300;
		System.out.println("You have poured: " + pour);

		if(amount < pour){
			System.out.println("You Spilled: " + (pour - amount) + "ml");
		}
		return pour;
	}

	public double pourOut(double amount) {
		double pourout = 80;
		double TotalAmount = (amount - pourout);
		System.out.println("You poured out: " + pourout + "ml");
		while(true){
			if(pourout > amount){
				System.out.println("The pourout is negative.");
			}
			else{
				this.setVolume(TotalAmount);
				break;
			}
		}
		return pourout;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

}
