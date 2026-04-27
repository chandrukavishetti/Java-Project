package com.chandru.stud_app.service;

import com.chandru.stud_app.dao.StudentDAO;
import com.chandru.stud_app.model.Student;

public class Stud_Service {
	StudentDAO sdao = new StudentDAO();

	public void addStudent(Student s) throws Exception {
		if (s.getName().isEmpty() || s.getAge() <= 0) {
			System.out.println("invalid data");
			return;
		}
		sdao.addStudent(s);
		System.out.println("student added successfully");
	}

	public void updateStudent(int id, String name, int age, double marks, String branch) throws Exception {
		if (!sdao.updateStudent(id, name, age, marks, branch)) {
			System.out.println("student not found");
		} else {
			System.out.println("updated successfully");
		}
	}

	public void deleteStudentById(int id) throws Exception {
		sdao.deleteStudentById(id);
		System.out.println("student deleted successfully");
	}

}
