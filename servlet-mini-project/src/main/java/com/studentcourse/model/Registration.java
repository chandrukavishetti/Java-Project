package com.studentcourse.model;

import java.time.LocalDate;

public class Registration {
	private int studentId;
	private int courseId;
	private LocalDate registrationDate;
	private String status;

	// Student details
	private String studentName;
	private String email;
	private String phone;
	private int age;
	private String city;

	// Course details
	private String courseName;
	private int duration;
	private double fees;
	private String trainerName;

	public Registration(int studentId, int courseId, LocalDate registrationDate, String status, String studentName,
			String email, String phone, int age, String city, String courseName, int duration, double fees,
			String trainerName) {
		this.studentId = studentId;
		this.courseId = courseId;
		this.registrationDate = registrationDate;
		this.status = status;
		this.studentName = studentName;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.city = city;
		this.courseName = courseName;
		this.duration = duration;
		this.fees = fees;
		this.trainerName = trainerName;
	}

	// Getters
	public int getStudentId() {
		return studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public String getStatus() {
		return status;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}

	public String getCourseName() {
		return courseName;
	}

	public int getDuration() {
		return duration;
	}

	public double getFees() {
		return fees;
	}

	public String getTrainerName() {
		return trainerName;
	}
}