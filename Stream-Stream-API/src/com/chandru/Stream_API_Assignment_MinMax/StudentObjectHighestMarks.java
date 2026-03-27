package com.chandru.Stream_API_Assignment_MinMax;

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

public class StudentObjectHighestMarks {

	public static void main(String[] args) {

		List<Student> studentlist = Arrays.asList(ObjectInitializing("chandrashekhar", 90),
				ObjectInitializing("kartik", 55), ObjectInitializing("chetan", 45), ObjectInitializing("aryan", 35),
				ObjectInitializing("deepak", 50));

		Optional<Student> maxStudent = studentlist.stream().max((a, b) -> a.getMarks() - b.getMarks());

		if (maxStudent.isPresent()) {
			Student s = maxStudent.get();
			System.out.println("Student with highest marks: " + s.getName() + " - " + s.getMarks());
		}
	}

	public static Student ObjectInitializing(String name, int marks) {
		return new Student(name, marks);
	}
}