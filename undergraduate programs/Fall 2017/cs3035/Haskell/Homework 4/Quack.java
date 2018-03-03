package DuckPond;
public class Quack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("Quack quack!");
	}

	@Override
	public void ShoutingDuck() {
		System.out.println("QUAKE QUAKE!");
	}

}
