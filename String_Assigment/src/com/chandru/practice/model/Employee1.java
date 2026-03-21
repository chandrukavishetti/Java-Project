package com.chandru.practice.model;

public class Employee1 extends Employee {
	private int workHours;

	public Employee1(int id, String fname, String email, double fees, int workHours) {
		// Chaining to Parent Constructor
		super(id, fname, email, fees);
		this.workHours = workHours;
		System.out.println("Child constructor finished.");
	}
}