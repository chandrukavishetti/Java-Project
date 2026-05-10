package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.RegistrationDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update-registration-status")
public class UpdateRegistrationStatusServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {
			resp.sendRedirect("login");
			return;
		}

		int studentId = Integer.parseInt(req.getParameter("studentId"));
		int courseId = Integer.parseInt(req.getParameter("courseId"));
		String status = req.getParameter("status");

		RegistrationDAO dao = new RegistrationDAO();

		try {
			boolean updated = dao.updateRegistrationStatus(studentId, courseId, status);
			if (updated) {
				session.setAttribute("message", "Registration status updated successfully");
			} else {
				session.setAttribute("error", "Failed to update registration status");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Error updating registration status");
		}

		resp.sendRedirect("view-registrations");
	}
}