package Zombie;

public class ZombieImpl implements Zombie{
	
	double weight;
	boolean isHungry;
	
	public ZombieImpl(double weight, boolean isHungry){
		this.weight = weight;
		this.isHungry = isHungry;
	}
	
	public String toString(){
		
		return "Zombie weighs " + weight + "KG " + (isHungry == true? "is hungry for brains" : " is not hungry for brains");
	
	}
	
	@Override
	public double getWeight() {
		return weight;
	}
	
	@Override
	public boolean isHungry() {
		return isHungry;
	}

	
	


}

