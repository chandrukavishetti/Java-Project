package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.RegistrationDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete-registration")
public class DeleteRegistrationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {
			resp.sendRedirect("login");
			return;
		}

		int studentId = Integer.parseInt(req.getParameter("studentId"));
		int courseId = Integer.parseInt(req.getParameter("courseId"));

		RegistrationDAO dao = new RegistrationDAO();

		try {
			boolean deleted = dao.deleteRegistration(studentId, courseId);
			if (deleted) {
				session.setAttribute("message", "Registration deleted successfully");
			} else {
				session.setAttribute("error", "Failed to delete registration");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Error deleting registration");
		}

		resp.sendRedirect("view-registrations");
	}
}