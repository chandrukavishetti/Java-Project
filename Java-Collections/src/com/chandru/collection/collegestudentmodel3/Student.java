package com.chandru.collection.collegestudentmodel3;

import java.util.HashMap;
import java.util.Map;

public abstract class Student implements Comparable<Student> {

	private int studentId;
	private String name;
	private String department;
	private Map<String, Integer> marks = new HashMap<>();

	public Student(int studentId, String name, String department, Map<String, Integer> marks) {

		this.studentId = studentId;
		this.name = name;
		this.department = department;
		this.marks = marks;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public Map<String, Integer> getMarks() {
		return marks;
	}

	@Override
	public int compareTo(Student s) {

		return Integer.compare(this.studentId, s.studentId);
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(studentId);
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Student) {

			Student s = (Student) obj;

			return this.studentId == s.studentId;
		}

		return false;
	}

	public abstract void display();
}