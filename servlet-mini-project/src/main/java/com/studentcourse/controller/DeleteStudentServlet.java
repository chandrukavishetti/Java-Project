package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student-delete")
public class DeleteStudentServlet extends HttpServlet {

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
		StudentDAO dao = new StudentDAO();

		try {
			// Check whether student has registrations
			boolean hasRegistrations = dao.hasRegistrations(studentId);

			if (hasRegistrations) {
				// If registrations exist: Do not delete, forward with error
				session.setAttribute("error",
						"Cannot delete student because registrations exist. Please delete registrations first.");
				resp.sendRedirect("student-view");
				return;
			}

			// If no registrations: Delete student
			Student student = new Student(studentId, "", "", "", 0, "");
			boolean status = dao.deleteStudent(student);

			if (status) {
				session.setAttribute("message", "Student deleted successfully");
			} else {
				session.setAttribute("error", "Failed to delete student");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Error deleting student");
		}

		resp.sendRedirect("student-view");
	}
}