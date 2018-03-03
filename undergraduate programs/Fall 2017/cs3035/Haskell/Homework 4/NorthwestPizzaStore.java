package headfirst.factory.pizzaaf;

public class NorthwestPizzaStore extends PizzaStore {


	protected Pizza createPizza(String item) {
		
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = new NorthwestIngredientFactory();
		
		if (item.equals("NorthwestPizza")) {

			pizza = new NorthWestPizza(ingredientFactory);
			pizza.setName("This is the best NorthwestPizza in the North West");

		} 
		return pizza;
	}
}
