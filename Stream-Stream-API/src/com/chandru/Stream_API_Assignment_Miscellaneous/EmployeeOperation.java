package com.chandru.Stream_API_Assignment_Miscellaneous;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.Optional;

class Employee {
	private String name;
	private double salary;
	private int joiningDate;
	private String gender;

	public Employee(String name, double salary, int joiningDate, String gender) {
		this.name = name;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public int getJoiningDate() {
		return joiningDate;
	}

	public String getGender() {
		return gender;
	}
}

public class EmployeeOperation {

	public static void main(String[] args) {

		List<Employee> employee = Arrays.asList(employeesList("Dhoni", 2000, 2025, "Male"),
				employeesList("smriti", 20000, 2024, "female"), employeesList("Rupa", 90000, 2026, "female"),
				employeesList("Sweta", 9000, 2023, "female"), employeesList("hardik", 10000, 2021, "Male"),
				employeesList("rohit", 10000, 2019, "Male"), employeesList("virat", 900000, 2016, "Male"),
				employeesList("chandrashekhar", 90000000, 2004, "Male"));

		// 1. Highest Salary Employee
		Optional<Employee> maxSalary = employee.stream().max(Comparator.comparing(Employee::getSalary));
		System.out.println("Highest salary employee : ");
		maxSalary.ifPresent(e -> printEmployee(e));

		// 2. Second Highest Salary
		Optional<Employee> secondHighest = employee.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst();
		System.out.println("\nSecond highest salary employee : ");
		secondHighest.ifPresent(e -> printEmployee(e));

		// 3. Sort by Joining Date
		System.out.println("\nSorted by Joining Date:");
		employee.stream().sorted(Comparator.comparing(Employee::getJoiningDate))
				.forEach(EmployeeOperation::printEmployee);

		// 4. Filter Male Employees
		System.out.println("\nMale Employees:");
		employee.stream().filter(e -> e.getGender().equalsIgnoreCase("male")).forEach(EmployeeOperation::printEmployee);
	}

	public static void printEmployee(Employee e) {
		System.out.println("Name: " + e.getName() + " | Salary: " + e.getSalary() + " | Joining Year: "
				+ e.getJoiningDate() + " | Gender: " + e.getGender());
	}

	public static Employee employeesList(String name, double salary, int joiningDate, String gender) {
		return new Employee(name, salary, joiningDate, gender);
	}
}