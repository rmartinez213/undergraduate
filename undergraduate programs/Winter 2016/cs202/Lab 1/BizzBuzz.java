package Lecture2;

public class BizzBuzz{

	public void Begin(){
		
		for(int i = 0 ; i < 100 ; i++){
			
			if (i % 5 == 0 && i % 3 == 0){
				System.out.println(i + " BizzBuzz");
			}
			else if (i % 3 == 0){
				System.out.println(i + " Bizz");
			}
			else if (i % 5 == 0){
				System.out.println(i + " Buzz");
			}
			else
				System.out.println(i);
		}
	}
}
