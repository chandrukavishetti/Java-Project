package com.chandru.Stream_API_Employee_mng.test;

import com.chandru.Stream_API_Employee_mng.model.*;

import java.util.*;

public class EmployeeTest {

	public static void main(String[] args) {

		InputHandler input = new InputHandler();
		EmployeeService service = new EmployeeService();

		List<Employee> list = new ArrayList<>();

		int n = input.getInt("Enter number of employees: ");

		for (int i = 0; i < n; i++) {
			System.out.println("\nEnter Employee " + (i + 1) + " details:");

			int id = input.getInt("ID: ");
			String name = input.getString("Name: ");
			String dept = input.getString("Department: ");
			double salary = input.getDouble("Salary: ");
			int exp = input.getInt("Experience: ");
			boolean status = input.getBoolean("Active Status");

			list.add(new Employee(id, name, dept, salary, exp, status));
		}

		System.out.println("\n--- Active Employees ---");
		service.getActiveEmployees(list).forEach(System.out::println);

		double threshold = input.getDouble("\nEnter salary threshold: ");
		System.out.println("\n--- Employees Above Salary ---");
		service.getEmployeesAboveSalary(list, threshold).forEach(System.out::println);

		System.out.println("\n--- Department Count ---");
		System.out.println(service.countDepartmentWise(list));

		System.out.println("\n--- Highest Paid Employee ---");
		service.getHighestPaidEmployee(list).ifPresent(System.out::println);

		System.out.println("\n--- Names Sorted By Salary ---");
		service.getNamesSortedBySalaryDesc(list).forEach(System.out::println);

		System.out.println("\n--- Group By Department ---");
		System.out.println(service.groupByDepartment(list));

		System.out.println("\n--- Average Salary By Department ---");
		System.out.println(service.getAverageSalaryByDept(list));
	}
}