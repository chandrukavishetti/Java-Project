package com.chandru.practice.model;

import java.util.Arrays;

public class Student {
	private String name;
	private int age;
	private double[] marks;

	public Student(String name, int age, double[] marks) {
		setName(name);
		setAge(age);
		setMarks(marks);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		if (age < 15 || age > 25) {
			throw new IllegalArgumentException("age should be between 15 and 25");
		}
		this.age = age;

	}

	public void setMarks(double[] inputMarks) {
		if (inputMarks == null || inputMarks.length != 5) {
			throw new IllegalArgumentException("the length should be 5");
		}
		for (double m : inputMarks) {
			if (m < 0 || m > 100) {
				throw new IllegalArgumentException("marks should be between 0 to 100");
			}

		}
		this.marks = Arrays.copyOf(inputMarks, inputMarks.length);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double[] getMarks() {
		return Arrays.copyOf(this.marks, this.marks.length);
	}

	public String getGrade() {
		double sum = 0;
		for (double m : marks) {
			sum += m;
		}
		double average = sum / marks.length;

		if (average >= 90)
			return "A";
		if (average >= 75)
			return "B";
		if (average >= 60)
			return "c";
		return "fail";
	}
}
