package DuckPond;
public class MuteQuack implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("<<Silence>>");		
	}

	@Override
	public void ShoutingDuck() {
		
	}
	
}
