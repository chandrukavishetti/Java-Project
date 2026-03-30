package com.chandru.Stream_API_Employee_mng.model;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {

	public List<Employee> getActiveEmployees(List<Employee> list) {
		return list.stream().filter(Employee::isActiveStatus).collect(Collectors.toList());
	}

	public List<Employee> getEmployeesAboveSalary(List<Employee> list, double salary) {
		return list.stream().filter(e -> e.getSalary() > salary).collect(Collectors.toList());
	}

	public Map<String, Long> countDepartmentWise(List<Employee> list) {
		return list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
	}

	public Optional<Employee> getHighestPaidEmployee(List<Employee> list) {
		return list.stream().max(Comparator.comparing(Employee::getSalary));
	}

	public List<String> getNamesSortedBySalaryDesc(List<Employee> list) {
		return list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).map(Employee::getName)
				.collect(Collectors.toList());
	}

	public Map<String, List<Employee>> groupByDepartment(List<Employee> list) {
		return list.stream().collect(Collectors.groupingBy(Employee::getDepartment));
	}

	public Map<String, Double> getAverageSalaryByDept(List<Employee> list) {
		return list.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
	}
}