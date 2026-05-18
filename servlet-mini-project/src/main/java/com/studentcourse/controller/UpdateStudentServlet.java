package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student-update")
public class UpdateStudentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {
			resp.sendRedirect("login");
			return;
		}

		int studentId = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		int age = Integer.parseInt(req.getParameter("age"));
		String city = req.getParameter("city");

		if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || city.isEmpty()) {
			session.setAttribute("error", "All fields are required");
			resp.sendRedirect("student-edit?id=" + studentId);
			return;
		}

		if (age < 18) {
			session.setAttribute("error", "Age must be 18 or above");
			resp.sendRedirect("student-edit?id=" + studentId);
			return;
		}

		if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || city.isEmpty()) {
			session.setAttribute("error", "All fields are required");
			resp.sendRedirect("student-edit?id=" + studentId);
			return;
		}

		if (!name.matches("^[a-zA-Z\\s]+$")) {
			session.setAttribute("error", "Name must contain only alphabets and spaces");
			resp.sendRedirect("student-edit?id=" + studentId);
			return;
		}

		if (!city.matches("^[a-zA-Z\\s]+$")) {
			session.setAttribute("error", "City name must contain only alphabets and spaces");
			resp.sendRedirect("student-edit?id=" + studentId);
			return;
		}

		if (!phone.matches("^[0-9]+$")) {
			session.setAttribute("error", "Phone number must contain only numbers");
			resp.sendRedirect("student-edit?id=" + studentId);
			return;
		}

		Student student = new Student(studentId, name, email, phone, age, city);
		StudentDAO dao = new StudentDAO();

		try {
			boolean status = dao.updateStudent(student);
			if (status) {
				session.setAttribute("message", "Student updated successfully");
			} else {
				session.setAttribute("error", "Failed to update student");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Error updating student");
		}

		resp.sendRedirect("student-view");
	}
}