package com.chandru.assignment_test.model;

public abstract class Staff {
	private int id;
	private String name;
	private String department;

	public Staff(int id, String name, String department) {
		StaffValidator.validateId(id);
		StaffValidator.validateName(name);
		StaffValidator.validateDepartment(department);

		this.id = id;
		this.name = name;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public abstract void displayDetails();

}
