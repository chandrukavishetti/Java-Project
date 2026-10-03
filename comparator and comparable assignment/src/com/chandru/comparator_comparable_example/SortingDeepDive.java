package com.chandru.comparator_comparable_example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 1. Comparable defines the DEFAULT sorting rule (by id)
class Employee implements Comparable<Employee> {
	private int id;
	private String name;
	private double salary;

	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public int compareTo(Employee other) {
		// Natural order: Ascending by ID
		return Integer.compare(this.id, other.id);
	}

	@Override
	public String toString() {
		return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
	}
}

public class SortingDeepDive {
	public static void main(String[] args) {
		List<Employee> team = new ArrayList<>();
		team.add(new Employee(103, "David", 75000));
		team.add(new Employee(101, "Alice", 92000));
		team.add(new Employee(104, "Bob", 60000));
		team.add(new Employee(102, "Charlie", 85000));

		// 1. Using Comparable (Natural order by ID)
		Collections.sort(team);
		System.out.println("Sorted by ID (Comparable default):");
		team.forEach(emp -> System.out.println("  " + emp));

		// 2. Using Comparator: Custom Strategy 1 (Sort by Salary Descending)
		Comparator<Employee> salaryComparator = (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary());
		team.sort(salaryComparator);
		System.out.println("\nSorted by Salary Descending (Comparator):");
		team.forEach(emp -> System.out.println("  " + emp));

		// 3. Using Comparator: Custom Strategy 2 (Sort Alphabetically by Name)
		team.sort(Comparator.comparing(Employee::getName));
		System.out.println("\nSorted by Name Alphabetical (Method Reference Comparator):");
		team.forEach(emp -> System.out.println("  " + emp));
	}
}