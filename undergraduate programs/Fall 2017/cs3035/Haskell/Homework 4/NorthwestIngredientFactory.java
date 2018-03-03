package headfirst.factory.pizzaaf;

public class NorthwestIngredientFactory implements PizzaIngredientFactory {

	public Dough createDough() {
		return new ThinCrustDough();
	}

	public Sauce createSauce() {
		return new HawaiianStyleAlfredo();
	}
	
	public Cheese createCheese() {
		return new Gouda();
	}
	
	public Seafood createSeafood() {
		return new MahiMahi();
	}

	//Unimplemented Options
	public Veggies[] createVeggies() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Pepperoni createPepperoni() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Clams createClam() {
		// TODO Auto-generated method stub
		return null;
	}

}
