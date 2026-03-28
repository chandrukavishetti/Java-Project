package com.chandru.Stream_API_Assignment_findFirst;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

public class StudentObjectMarksMoreThan40 {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(studentList("chandrashekhar", 99), studentList("kartik", 66),
				studentList("Dhoni", 20), studentList("Ambati Rayadu", 0)

		);
		Optional<Student> result = students.stream().filter(std -> std.getMarks() > 40).findFirst();

		if (result.isPresent()) {
			Student s = result.get();
			System.out.println("Student name is : " + s.getName() + " |  Student marks is : " + s.getMarks());
		}

	}

	public static Student studentList(String name, int marks) {
		return new Student(name, marks);
	}
}
