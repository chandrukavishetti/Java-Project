package com.chandru.assignment_test.model;

public class StudentService {

	private StudentRepository repository;

	public StudentService(StudentRepository repository) {
		this.repository = repository;
	}

	public void addStudent(Student student) {
		repository.addStudent(student);
	}

	public void displayStudents() {

		Student[] list = repository.getAllStudents();

		for (Student s : list) {

			if (s != null) {
				s.displayDetails(); // polymorphism
			}
		}
	}
}