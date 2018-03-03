import java.util.Scanner;
public class Hw4P1{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);



		System.out.println("Plese enter the coordinates in a clockwise order.");
		System.out.print("Enter the GPS coordinates for the 1st city: ");
		double firstcity_x = Math.toRadians(input.nextDouble());
		double firstcity_y = Math.toRadians(input.nextDouble());
		System.out.print("Enter the GPS coordinates for the 2nd city: ");
		double secondcity_x = Math.toRadians(input.nextDouble());
		double secondcity_y = Math.toRadians(input.nextDouble());
		System.out.print("Enter the GPS coordinates for the 3rd city: ");
		double thirdcity_x = Math.toRadians(input.nextDouble());
		double thirdcity_y = Math.toRadians(input.nextDouble());
		System.out.print("Enter the GPS coordinates for the 4th city: ");
		double fourthcity_x = Math.toRadians(input.nextDouble());
		double fourthcity_y = Math.toRadians(input.nextDouble());

		double distance1 = (6371.01) * Math.acos(Math.sin(firstcity_x) * Math.sin(secondcity_x) + Math.cos(firstcity_x) * Math.cos(secondcity_x) * (Math.cos(firstcity_y - secondcity_y)));

		double distance2 = (6371.01) * Math.acos(Math.sin(secondcity_x) * Math.sin(thirdcity_x) + Math.cos(secondcity_x) * Math.cos(thirdcity_x) * (Math.cos(secondcity_y - thirdcity_y)));

		double distance3 =  (6371.01) * Math.acos(Math.sin(thirdcity_x) * Math.sin(fourthcity_x) + Math.cos(thirdcity_x) * Math.cos(fourthcity_x) * (Math.cos(thirdcity_y - fourthcity_y)));

		double distance4 = (6371.01) * Math.acos(Math.sin(fourthcity_x) * Math.sin(firstcity_x) + Math.cos(fourthcity_x) * Math.cos(firstcity_x) * (Math.cos(fourthcity_y - firstcity_y)));

		double distance5 = (6371.01) * Math.acos(Math.sin(firstcity_x) * Math.sin(thirdcity_x) + Math.cos(firstcity_x) * Math.cos(thirdcity_x) * (Math.cos(firstcity_y - thirdcity_y)));

		double s = (distance1 + distance2 + distance5) / 2;

		double s2 = (distance3 + distance4 + distance5) / 2;

		double area = Math.sqrt(s * ((s - distance1) * (s - distance2) * (s - distance5)));
		double area2 = Math.sqrt(s2 * ((s2 - distance3) * (s2 - distance4) * (s2 - distance5)));
		double area3 = area + area2;



		System.out.printf("The area is: %9.3f",area3);
	}
}