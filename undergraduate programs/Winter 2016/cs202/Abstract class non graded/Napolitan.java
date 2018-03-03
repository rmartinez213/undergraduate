package AbstractPizza;

public class Napolitan extends Pizza{
	

	public static double pi = 3.14;
	public static double radius = 5;
	
	@Override
	public void getArea(){
		
		double Area = pi * radius * radius;
		
		System.out.println("The area is: " + Area);
	}

	@Override
	public int getTopping() {
		System.out.println("You have 5 toppings.");
		return 5;
	}

}
