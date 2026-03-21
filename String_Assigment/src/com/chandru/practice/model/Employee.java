package com.chandru.practice.model;

public class Employee {
	protected int id;
	protected String fname;
	protected String email;
	protected double fees;

	// Overloaded Constructor 1: 2 parameters
	public Employee(int id, String fname) {
		// Chaining to the 4-parameter constructor with default values
		this(id, fname, "not provided", 0.0);

		System.out.println("2-param constructor finished." + id + " " + fname);
	}

	// Overloaded Constructor 2: 4 parameters
	public Employee(int id, String fname, String email, double fees) {
		this.id = id;
		this.fname = fname;
		this.email = email;
		this.fees = fees;
		System.out.println("4-param constructor finished for: " + id + " " + fname + " " + email + " " + fees);
	}
}