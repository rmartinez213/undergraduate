package Hw1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollSystem {

	public void PayrollSystem() {





		ArrayList<Employee> employee1 = new ArrayList<Employee>();
		employee1.add(new Employee("E19203", "John", "Anthoney",  26.84, 36.5));
		employee1.add(new Employee("E18293", "Geo", "Bautista", 25.34, 23));
		employee1.add(new Employee("E71920", "Mat", "Rodriguez", 27.74, 25.5));
		employee1.add(new Employee("E32693", "Adriana", "Whiy", 30.54, 40));
		employee1.add(new Employee("E42910", "Miguel", "Cayetano", 45.57, 20));



		addEmployee(employee1);
	}

	public void addEmployee(ArrayList<Employee> employee1){

		Scanner input = new Scanner(System.in);



		for(;true;){
			System.out.print("Would you like to add an Employee or drop? (1 = Employee List, 2 = ISSUE PAYCHECK, 3 = SET HOURS, 4 = ADD, 5 = REMOVE, 6 = NONE)");
			int User = input.nextInt();
			input.nextLine();
			
			
			if(User == 1){
				for(Employee x : employee1){
					Paycheck object3 = new Paycheck(x);
					System.out.println(object3.toStringEmployee());
				}
				continue;
			}
			else if(User == 2){
				for(Employee x : employee1){
					Paycheck object3 = new Paycheck(x);
					System.out.println(object3.toString());
				}
				continue;
			}
			else if (User ==3){
				System.out.print("What EmployeeID would like to set hours to?");
				String EmpID = input.nextLine();
				System.out.print("What EmployeeID would like to set hours to?");
				int newHours = input.nextInt();
				
				
				int count = 0;
				for(Employee a : employee1){
					if(EmpID.equals(a.getEmployeeID())){
						a.setHoursWorked(newHours);
						break;
					}

					count++;

				}
			}
			else if(User == 4){
				System.out.print("Type in the the EmployeeID: ");
				String EmployeeID = input.next();
				input.nextLine();
				System.out.print("Type in the the first name: ");
				String EmployeeFirstName = input.nextLine();
				System.out.print("Type in the the last name: ");
				String EmployeeLastName = input.nextLine();
				System.out.print("Type in the the hourley wage: ");
				int HourleyWage = input.nextInt();
				System.out.print("Type in the the hours: ");
				int Hours = input.nextInt();

				employee1.add(new Employee(EmployeeID, EmployeeFirstName, EmployeeLastName, HourleyWage, Hours));
				continue;
			}

			else if(User == 5){
				System.out.print("Type in the EmployeeID you would like drop: ");
				String drop = input.nextLine();


				int count = 0;
				for(Employee a : employee1){
					if(drop.equals(a.getEmployeeID())){
						break;
					}

					count++;

				}

				employee1.remove(count);
				continue;
			}

			else if(User == 6){
				System.out.println("Thank you");
				break;
			}
		}

	}

}



