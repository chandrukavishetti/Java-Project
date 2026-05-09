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

@WebServlet("/student-delete")
public class DeleteStudentServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("DeleteStudentServlet Initialized");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {
			resp.sendRedirect("login");
			return;
		}

		String studentIdStr = req.getParameter("id");

		if (studentIdStr == null || studentIdStr.isEmpty()) {
			session.setAttribute("error", "Invalid student ID");
			resp.sendRedirect("student-view");
			return;
		}

		int studentId = Integer.parseInt(studentIdStr);
		Student student = new Student(studentId, "", "", "", 0, "");

		StudentDAO dao = new StudentDAO();

		try {
			boolean status = dao.deleteStudent(student);

			if (status) {
				session.setAttribute("message", "Student deleted successfully");
			} else {
				session.setAttribute("error", "Cannot delete student because registrations exist");
			}
		} catch (Exception e) {
			if (e.getMessage().contains("foreign key") || e.getMessage().contains("constraint")) {
				session.setAttribute("error", "Cannot delete student because registrations exist");
			} else {
				session.setAttribute("error", "Error deleting student");
			}
			e.printStackTrace();
		}

		resp.sendRedirect("student-view");
	}
}