package com.chandru.Stream_API_Assignment_Sorted;

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

public class SortingStudentObject {
	public static void main(String[] args) {
		List<Student> sorting = Arrays.asList(sortingObjects("chandrashekhar", 26), sortingObjects("Virat", 18),
				sortingObjects("hardik", 33), sortingObjects("Rohit", 45));
		sorting.stream().sorted((s1, s2) -> s1.getMarks() - s2.getMarks())
				.forEach(s -> System.out.println(s.getName() + " - " + s.getMarks()));

	}

	public static Student sortingObjects(String name, int marks) {
		return new Student(name, marks);
	}
}
