package com.chandru.practice.test;

import com.chandru.practice.model.Employee;

public class EmployeeTester {
	public static void main(String[] args) {
		// Creating 3 objects
		Employee e1 = new Employee("Chandru1", 26);
		Employee e2 = new Employee("Chandru2", 27);
		Employee e3 = new Employee("Chandru3", 28);

		// Printing details
		System.out.println("Company: " + Employee.companyName);
		System.out.println("Employee 1 ID: " + e1.employeeId);
		System.out.println("Employee 2 ID: " + e2.employeeId);
		System.out.println("Employee 3 ID: " + e3.employeeId);

		// Accessing static method via Class name (Best Practice)
		System.out.println("Total Employees: " + Employee.getEmployeeCount());
	}
}