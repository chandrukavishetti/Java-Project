package com.chandru.collection.collegestudentmodel3;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StudentRepository {

	private Set<Student> students = new TreeSet<>();

	public void addStudent(Student student) throws DuplicateStudentException {
		if (!students.add(student)) {
			throw new DuplicateStudentException("Duplicate order id : " + student.getStudentId());
		}
	}

	public void displayStudents() {
		for (Student student : students) {
			student.display();
		}
	}

	public Student findStudent(int id) {
		for (Student student : students) {
			if (student.getStudentId() == id) {
				return student;
			}
		}
		return null;
	}

	public void removeStudent(int id) {
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			if (student.getStudentId() == id) {
				iterator.remove();
			}
		}
	}
}
