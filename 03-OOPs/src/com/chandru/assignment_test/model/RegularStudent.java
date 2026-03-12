package com.chandru.assignment_test.model;

public class RegularStudent extends Student {

	public RegularStudent(int studentId, String name, String course) {
		super(studentId, name, course);
	}

	@Override
	public void displayDetails() {

		System.out.println("\nRegular Student");
		System.out.println("ID: " + getStudentId());
		System.out.println("Name: " + getName());
		System.out.println("Course: " + getCourse());
	}
}