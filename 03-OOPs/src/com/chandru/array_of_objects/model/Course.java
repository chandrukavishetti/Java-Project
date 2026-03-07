package com.chandru.array_of_objects.model;

public class Course {
	protected int courseId;
	protected String courseName;
	protected double baseFee;

	protected static int totalCourses = 0;

	public Course(int courseId, String courseName, double baseFee) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.baseFee = baseFee;
		totalCourses++;

	}

	public double calculateFee() {
		return baseFee;
	}

	public static int getTotalCourses() {
		return totalCourses;
	}

	public void displayCourse() {
		System.out.println("-----------------------------");
		System.out.println("Course ID   : " + courseId);
		System.out.println("Course Name : " + courseName);
		System.out.println("base Fee  : " + baseFee);
	}

}
