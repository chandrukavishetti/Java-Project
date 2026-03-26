package com.chandru.Stream_API_Assignment_filter;

import java.util.Arrays;
import java.util.List;

class Student {
	private String name;
	private int marks;

	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public int getMarks() {
		return marks;
	}
}

public class PassedStudents {
	public static void main(String[] args) {
		List<Student> passedStudents = Arrays.asList(studentDetails("akash", 27), studentDetails("Deepak", 78),
				studentDetails("chetan", 45), studentDetails("Chandrashekhar", 85), studentDetails("kartik", 80));

		System.out.println("students more than 50 marks ");

		passedStudents.stream().filter(student -> student.getMarks() > 50)
				.forEach(student -> System.out.println("[" + student.getName() + "-" + student.getMarks() + "]"));

	}

	public static Student studentDetails(String name, int marks) {
		return new Student(name, marks);
	}

}
