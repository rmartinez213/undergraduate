

public class Cup extends Vessel{

	public double volume;

	public Cup(double a){
		this.volume = volume;
	}

	final double pi = Math.PI;
	final double RadiusOfLip = 4;

	@Override
	public double getCurrentContentsInCC() {
		System.out.println("Youre current contents in CC is: " + volume + "ml");
		return volume;
	}

	@Override
	public double getCapacityInCC() {
		double Volume =  0.5 * pi * Math.pow(RadiusOfLip, 3) * (4/3);
		System.out.println("The volume in the glass is: " + Volume);
		return Volume;
	}

	@Override
	public double pourIn(double amount) {
		double pour = 70;
		System.out.println("You have poured: " + pour + "ml");

		if(amount < pour){
			System.out.println("You Spilled: " + (pour - amount) + "ml");
		}
		return pour;
	}

	public double pourOut(double amount) {
		double pourout = 35;
		System.out.println("You poured out: " + pourout + "ml");

		while(true){
			if(pourout > amount){
				System.out.println("The pourout is negative.");
			}
			else{

				double TotalVolume = (amount - pourout); 
				this.setVolume(TotalVolume);
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
