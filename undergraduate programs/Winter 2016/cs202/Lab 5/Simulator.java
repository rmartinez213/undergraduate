package Zombie;

import java.util.Random;

public class Simulator {


	public double getGaussianDouble(double mean, double std, double min, double max) {
		Random r = new Random();
		double randDoub = r.nextGaussian() * std + mean;
		if (randDoub > max)	randDoub = max;
		if (randDoub < min)	randDoub = min;

		return randDoub;
	}

	public boolean getBoolean(double propTrue){
		Random r = new Random();
		double randDoub = r.nextDouble();
		if(randDoub <= propTrue) return true;
		return false;
	}	
}

