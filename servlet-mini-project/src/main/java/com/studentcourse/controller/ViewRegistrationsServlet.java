package com.studentcourse.controller;

import java.io.IOException;
import java.util.List;

import com.studentcourse.dao.RegistrationDAO;
import com.studentcourse.model.Registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/view-registrations")
public class ViewRegistrationsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {
			resp.sendRedirect("login");
			return;
		}

		RegistrationDAO dao = new RegistrationDAO();

		try {
			List<Registration> registrations = dao.getAllRegistrations();
			req.setAttribute("registrations", registrations);
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/registration-list.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("dashboard");
		}
	}
}