package com.chandru.stud_app.model;

public class Student {
	private int id;
	private String name;
	private double marks;
	private int age;
	private String branch;

	public Student(int id, String name, double marks, int age, String branch) {
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.age = age;
		this.branch = branch;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getMarks() {
		return marks;
	}

	public int getAge() {
		return age;
	}

	public String getBranch() {
		return branch;
	}

}
