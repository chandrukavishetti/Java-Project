package com.studentcourse.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.studentcourse.dao.RegistrationDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register-course")
public class RegisterStudentCourseServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {
			resp.sendRedirect("login");
			return;
		}

		int studentId = Integer.parseInt(req.getParameter("studentId"));
		int courseId = Integer.parseInt(req.getParameter("courseId"));
		LocalDate registrationDate = LocalDate.now();

		RegistrationDAO dao = new RegistrationDAO();

		try {
			boolean status = dao.registerStudent(studentId, courseId, registrationDate);
			if (status) {
				session.setAttribute("message", "Student registered for course successfully");
			} else {
				session.setAttribute("error", "Failed to register student for course");
			}
		} catch (Exception e) {
			if (e.getMessage().contains("Duplicate entry") || e.getMessage().contains("PRIMARY")) {
				session.setAttribute("error", "Student already registered for this course");
			} else {
				session.setAttribute("error", "Error registering student");
			}
			e.printStackTrace();
		}

		resp.sendRedirect("view-registrations");
	}
}