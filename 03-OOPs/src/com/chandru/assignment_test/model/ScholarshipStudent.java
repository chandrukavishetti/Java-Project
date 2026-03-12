package com.chandru.assignment_test.model;

public class ScholarshipStudent extends Student {

	private double scholarshipAmount;

	public ScholarshipStudent(int studentId, String name, String course, double scholarshipAmount) {

		super(studentId, name, course);
		StudentValidator.validateScholarship(scholarshipAmount);
		this.scholarshipAmount = scholarshipAmount;
	}

	@Override
	public void displayDetails() {

		System.out.println("\nScholarship Student");
		System.out.println("ID: " + getStudentId());
		System.out.println("Name: " + getName());
		System.out.println("Course: " + getCourse());
		System.out.println("Scholarship: " + scholarshipAmount);
	}
}