import java.util.Scanner;
public class Hw3P5{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);

		while(true) {
			System.out.println("Math Tutor Menu");
			System.out.println("1. Addition Problem");
			System.out.println("2. Subtract Problem");
			System.out.println("3. Multiplication Problem");
			System.out.println("4. Random Problem");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int user = input.nextInt();

			int random1 = 0 + (int)(Math.random() * (100 - 0 + 1));
			int random2 = 0 + (int)(Math.random() * (100 - 0 + 1));
			int random_math = random1 + random2;
			int random_subtract = random1 - random2;
			int random_multiply = random1 * random2;
			int random_value = 0 + (int)(Math.random() * (2 - 0 + 1));


			if  (user == 1){
				System.out.print(random1 + " + " + random2 + " is ");
				int user_math_user = input.nextInt();
				if(user_math_user == random_math){
					System.out.println("You are right!");
				}
				else
					System.out.println("You are wrong.");
			}


			else if  (user == 2){
				System.out.print(random1 + " - " + random2 + " is ");
				int subtract_user = input.nextInt();
				if (subtract_user == random_subtract){
					System.out.println("You are right!");
				}
				else
					System.out.println("You are wrong.");
			}

			else if  (user == 3){
				System.out.print(random1 + " * " + random2 + " is ");
				int multiply_user = input.nextInt();
				if(multiply_user == random_multiply){
					System.out.println("You are right!");
				}
				else{
					System.out.println("You are wrong.");
				}
			}

			else if  (user == 4){
				if(random_value == 0){
					System.out.print(random1 + " + " + random2 + " is ");
					int user_math_user = input.nextInt();
					if(user_math_user == random_math){
						System.out.println("You are right!");
					}
					else{
						System.out.println("You are wrong.");
					}
				}
				else if(random_value == 1){
					System.out.print(random1 + " - " + random2 + " is ");
					int subtract_user = input.nextInt();
					if (subtract_user == random_subtract){
						System.out.println("You are right!");
					}
					else{
						System.out.println("You are wrong.");
					}
				}
				else if(random_value == 2){
					System.out.print(random1 + " * " + random2 + " is ");
					int multiply_user = input.nextInt();
					if(multiply_user == random_multiply){
						System.out.println("You are right!");
					}
					else{
						System.out.println("You are wrong.");
					}
				}
			}
			else if (user == 5){
				System.exit(1);
			}

			System.out.println();
		}
	}
}