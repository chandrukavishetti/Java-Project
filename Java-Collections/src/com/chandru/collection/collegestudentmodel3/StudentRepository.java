package com.chandru.collection.collegestudentmodel3;

import java.util.Set;
import java.util.TreeSet;

public class StudentRepository {

	private Set<Student> students = new TreeSet<>();

	public void addStudent(Student student) throws DuplicateStudentException {
		if (!students.add(student)) {
			throw new DuplicateStudentException("Duplicate order id : " + student.getStudentId());
		}
	}
}
