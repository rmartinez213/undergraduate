

public abstract class Vessel {
	
	//Returns the amount of liquid in the vessel
	public abstract double getCurrentContentsInCC();
	public abstract double getCapacityInCC();
	//Returns the amount of liquid poured into the vessel
	public abstract double pourIn(double getCapacityInCC);
	//Returns the amount of liquid poured out of the vessel
	public abstract double pourOut(double amount);
}
