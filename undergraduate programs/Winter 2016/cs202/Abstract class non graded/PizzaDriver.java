package AbstractPizza;

public class PizzaDriver {

	public static void main(String[] args) {
		Napolitan Nobj = new Napolitan();
		Nobj.getArea();
		
		int Topping = Nobj.getTopping();
		Nobj.addTopping(Topping);
		
	}

}
