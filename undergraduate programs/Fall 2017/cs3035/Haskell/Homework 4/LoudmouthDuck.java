package DuckPond;

public class LoudmouthDuck extends Duck{

	public LoudmouthDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void performFly() {
		// TODO Auto-generated method stub
		
	}


	public void performQuack() {
		quackBehavior.ShoutingDuck();
	}

}
