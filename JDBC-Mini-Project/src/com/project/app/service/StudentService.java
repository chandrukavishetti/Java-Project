package com.project.app.service;

import com.project.app.dao.*;
import com.project.app.model.*;

public class StudentService {

	StudentDAO sdao = new StudentDAO();
	RegistrationDAO rdao = new RegistrationDAO();

	public void addStudent(Student s) throws Exception {
		if (s.getName().isEmpty() || s.getAge() <= 0) {
			System.out.println("Invalid data");
			return;
		}

		if (sdao.studentExists(s.getId())) {
			System.out.println("Duplicate ID");
			return;
		}

		sdao.addStudent(s);
		System.out.println("Student Added");
	}

	public void registerCourse(int id, String course, double fee) throws Exception {
		if (fee <= 0) {
			System.out.println("Invalid fee");
			return;
		}

		if (!sdao.studentExists(id)) {
			System.out.println("Student not found");
			return;
		}

		rdao.registerCourse(id, course, fee);
		System.out.println("Registered Successfully");
	}

	public void updateStudent(int id, String name, String branch) throws Exception {
		if (!sdao.updateStudent(id, name, branch)) {
			System.out.println("Student not found");
		} else {
			System.out.println("Updated Successfully");
		}
	}

	public void deleteStudent(int id) throws Exception {
		sdao.deleteStudent(id);
		System.out.println("Deleted Successfully");
	}

	public void updateCourseFee(int id, String course, double fee) throws Exception {
		if (fee <= 0) {
			System.out.println("Fee must be positive!");
			return;
		}
		if (rdao.updateFee(id, course, fee)) {
			System.out.println("Fee Updated Successfully");
		} else {
			System.out.println("Registration not found for this student and course");
		}
	}

	public void cancelRegistration(int id, String course) throws Exception {
		if (rdao.cancelRegistration(id, course)) {
			System.out.println("Registration Cancelled Successfully");
		} else {
			System.out.println("Registration not found");
		}
	}
}