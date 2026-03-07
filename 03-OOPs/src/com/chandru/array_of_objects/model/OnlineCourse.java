package com.chandru.array_of_objects.model;

public class OnlineCourse extends Course {
	private double platformFee;

	public OnlineCourse(int courseId, String courseName, double baseFee, double platformFee) {
		super(courseId, courseName, baseFee);
		this.platformFee = platformFee;
	}

	@Override
	public double calculateFee() {
		return baseFee + platformFee;
	}

}
