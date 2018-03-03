package Zombie;

import java.util.ArrayList;

public class ZombieHorde {
	
	String location;
	int NumberZombies;
	
	ArrayList<Zombie> Zombies = new ArrayList<Zombie>();
	
	public ZombieHorde(String location, int NumberZombies){
		int NMZ = 6;
		
		this.location = location;
		this.NumberZombies = NMZ;
		
		
		
		for(int i = 0 ; i <= NMZ ; i++){
			Simulator obj = new Simulator();
			ZombieImpl zomobj = new ZombieImpl(obj.getGaussianDouble(50, 20, 10.512, 100), obj.getBoolean(0.50));
			
			Zombies.add(zomobj);
		}
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumberZombies() {
		return NumberZombies;
	}

	public void setNumberZombies(int numberZombies) {
		NumberZombies = numberZombies;
	}

	public void zombieattack(){
		System.out.println("A horde of " + getNumberZombies() + " zombies are attacking in " + getLocation() + ".");
		
		for(Zombie x : Zombies){
			System.out.println(x.toString());
		}
	}
	
}
