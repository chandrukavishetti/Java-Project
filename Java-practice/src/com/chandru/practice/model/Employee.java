package com.chandru.practice.model;

public class Employee {
	// Instance variables (unique to each object)
	public String name;
	public int employeeId;

	// Static variables (shared across all objects)
	public static String companyName = "TechCorp";
	private static int employeeCount = 0;

	public Employee(String name, int employeeId) {
		this.name = name;
		this.employeeId = employeeId;
		// Increment the shared count every time a new instance is born
		employeeCount++;
	}

	// Static method to return the total count
	public static int getEmployeeCount() {
		return employeeCount;
	}
}