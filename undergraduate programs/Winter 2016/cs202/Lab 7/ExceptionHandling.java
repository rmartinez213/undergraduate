package Quiz5;

public class ExceptionHandling {

	public static void main(String[] args) {
		
		try{
			new CircleClass(10);
			new CircleClass(2);
		}catch(CustomException c){
			System.out.println(c);
		}
		
		System.out.println("No of objects created :" + CircleClass.getNumberOfObjects());

	}

}
