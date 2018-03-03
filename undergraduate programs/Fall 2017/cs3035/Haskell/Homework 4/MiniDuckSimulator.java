package DuckPond;
public class MiniDuckSimulator {

	public static void main(String[] args) {
		
		Duck mallard = new MallardDuck();
		Duck rubberDuck = new RubberDuck();
		Duck LoudmouthDuck = new LoudmouthDuck();
		
		//Mallard Duck
		System.out.println("Mallard Duck");
		mallard.performFly();
		LoudmouthDuck.performQuack();
		mallard.display();
		
		//Rubber Duck
		System.out.println("\r\rRubber Duck");
		rubberDuck.performFly();
		rubberDuck.performQuack();
		rubberDuck.display();
		
		//Loudmouth Duck
		System.out.println("\r\rLoud Mouth Duck");
		LoudmouthDuck.performQuack();
		
		System.out.println("\r\rRubber ducky eats a magic pellet.");
		rubberDuck.setFlyBehavior(new RocketFly());
		rubberDuck.performFly();
		
		System.out.println("Mallard duck eats a magic pellet.");
		mallard.setFlyBehavior(new RocketFly());
		System.out.println("Mallard says:");
		mallard.performFly();
	}

}
