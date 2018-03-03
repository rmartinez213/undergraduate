
package Quiz5;

public class CircleClass{
	
	private double r;
	private static int numberOfObjects = 0;

	public CircleClass(int i) throws CustomException{
		if(i < 5){
			numberOfObjects++;
			throw new CustomException(r);
			
		}
		else{
			this.r = r;
			numberOfObjects++;		
		}
	}
	
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	
	public static int getNumberOfObjects() {
		return numberOfObjects;
	}
	public static void setNumberOfObjects(int numberOfObjects) {
		CircleClass.numberOfObjects = numberOfObjects;
	}
	

	
	
}
