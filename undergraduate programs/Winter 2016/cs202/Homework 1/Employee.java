package Hw1;
import java.util.Scanner;

public class Employee {
	
	public String EmployeeID;
	public String EmployeeFirstName;
	public String EmployeeLastName;
	public double HourleyWage;
	public double HoursWorked;
	public double calcPay;



	public Employee(String EmployeeID, String EmployeeLastName, String EmployeeFirstName, double HourleyWage, double HoursWorked){
		this.EmployeeID = EmployeeID;
		this.EmployeeFirstName = EmployeeFirstName;
		this.EmployeeLastName = EmployeeLastName;
		this.HourleyWage = HourleyWage;
		this.HoursWorked = HoursWorked;
	}
	

	public String getEmployeeID() {
		return EmployeeID;
	}



	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}

	public String getEmployeeFirstName() {
		return EmployeeFirstName;
	}


	public void setEmployeeFirstName(String employeeFirstName) {
		EmployeeFirstName = employeeFirstName;
	}


	public String getEmployeeLastName() {
		return EmployeeLastName;
	}


	public void setEmployeeLastName(String employeeLastName) {
		EmployeeLastName = employeeLastName;
	}


	public double getHourleyWage() {
		return HourleyWage;
	}



	public void setHourleyWage(double hourleyWage) {
		HourleyWage = hourleyWage;
	}

	public double getHoursWorked() {
		return HoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		HoursWorked = hoursWorked;
	}
	
	public double getCalcPay(double getHourleyWage, double getHoursWorked) {
		calcPay = getHourleyWage * getHoursWorked;
		return calcPay;
	}

	public void setCalcPay(double calcPay) {		
		this.calcPay = calcPay;
	}
	
	
}
