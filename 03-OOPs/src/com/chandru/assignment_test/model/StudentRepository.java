package com.chandru.assignment_test.model;

public class StudentRepository {

	private Student[] students;
	private int index = 0;

	public StudentRepository(int size) {
		students = new Student[size];
	}

	public void addStudent(Student student) {

		if (index < students.length) {
			students[index++] = student;
		} else {
			System.out.println("Student storage full");
		}
	}

	public Student[] getAllStudents() {
		return students;
	}
}