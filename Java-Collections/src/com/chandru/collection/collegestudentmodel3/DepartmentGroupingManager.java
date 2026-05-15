package com.chandru.collection.collegestudentmodel3;

import java.util.*;

public class DepartmentGroupingManager {

	private Map<String, List<Student>> map = new HashMap<>();

	public void addStudent(Student student) {

		map.putIfAbsent(student.getDepartment(), new ArrayList<>());

		map.get(student.getDepartment()).add(student);
	}

	public void displayDepartmentWiseStudents() {

		for (String dept : map.keySet()) {

			System.out.println("\nDepartment : " + dept);

			for (Student s : map.get(dept)) {

				s.display();
			}
		}
	}
}