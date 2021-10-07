package com.sujata.database;

import java.util.ArrayList;

import com.sujata.beans.Employee;

public class EmployeeDataBase {
	private static ArrayList<Employee> employees=new ArrayList<>();
	static {
		employees.add(0,new Employee(101, "Akash", "IT", "Sr. Manager", 250000));
		employees.add(1,new Employee(102, "Bharat", "IT", "Associate", 100000));
		employees.add(2,new Employee(103, "Charu", "IT", "Sr. Associate", 120000));
		employees.add(3,new Employee(104, "Disha", "IT", "Executive", 50000));
		employees.add(4,new Employee(105, "Esha", "IT", "Team Lead", 150000));
	}
	public static ArrayList<Employee> getEmployees() {
		return employees;
	}
	public static void setEmployees(ArrayList<Employee> employees) {
		EmployeeDataBase.employees = employees;
	}
	
	

}
