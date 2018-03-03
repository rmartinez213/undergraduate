package Hw1;

import java.util.ArrayList;
import java.util.Scanner;

public class Paycheck {

	public String EmployeeID;
	public String EmployeeLastName;
	public String EmployeeFirstName;
	public double HourleyWage;
	public double HoursWorked;
	public double calcPay;


	public Paycheck(Employee x) {
		EmployeeID = x.getEmployeeID();
		EmployeeFirstName = x.getEmployeeFirstName();
		EmployeeLastName = x.getEmployeeLastName();
		HourleyWage = x.getHourleyWage();
		HoursWorked = x.getHoursWorked();
		calcPay = x.getCalcPay(x.getHourleyWage(), x.getHoursWorked());
		x.setHoursWorked(0);
	}


	public String toString(){
		return "Paycheck for $" + calcPay + " issued to " + EmployeeID + " " + EmployeeFirstName + " " + EmployeeLastName ;
	}
	
	public String toStringEmployee(){
		return "EmployeeID: " + EmployeeID + "\t Employee Name: " + EmployeeFirstName + " " + EmployeeLastName + "\t Hourley Wage: " + HourleyWage + " \t Hours Worked: " + HoursWorked; 
	}

	public void NoHours(ArrayList<Employee> employee1){
		HoursWorked = 0;
		calcPay = HoursWorked * HourleyWage;
	}
	
}
