package Quiz5;
public class CustomException extends Exception {
	double radius;
	public CustomException(double radius) {
		System.out.println("Invalid Radius : "+ radius);
		
	}
}
