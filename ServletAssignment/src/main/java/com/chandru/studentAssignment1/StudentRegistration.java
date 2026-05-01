package com.chandru.studentAssignment1;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentRegistration")
public class StudentRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("StudentAssignment1/RegistrationForm.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("studentName");
		String email = req.getParameter("email");
		String ageStr = req.getParameter("age");
		String course = req.getParameter("courseName");
		String batch = req.getParameter("batchTime");

		boolean isValid = true;
		String errorMsg = "";

		if (name == null || name.trim().isEmpty()) {
			isValid = false;
			errorMsg = "Student Name is required";
		} else if (email == null || email.trim().isEmpty()) {
			isValid = false;
			errorMsg = "Email is required";
		} else if (ageStr == null || ageStr.trim().isEmpty()) {
			isValid = false;
			errorMsg = "Age is required";
		} else {
			try {
				int age = Integer.parseInt(ageStr);
				if (age < 18) {
					isValid = false;
					errorMsg = "Age must be 18 or above";
				}
			} catch (NumberFormatException e) {
				isValid = false;
				errorMsg = "Please enter a valid age";
			}
		}

		if (course == null || course.trim().isEmpty()) {
			isValid = false;
			errorMsg = "Please select a course";
		}

		if (batch == null || batch.trim().isEmpty()) {
			isValid = false;
			errorMsg = "Please select preferred batch time";
		}

		if (isValid) {
			// Forward to confirmation page
			req.setAttribute("studentName", name);
			req.setAttribute("email", email);
			req.setAttribute("age", ageStr);
			req.setAttribute("courseName", course);
			req.setAttribute("batchTime", batch);

			RequestDispatcher rd = req.getRequestDispatcher("/StudentAssignment1/Confirmation.jsp");
			rd.forward(req, resp);
		} else {
			// Forward back to form with error message + previous data
			req.setAttribute("errorMsg", errorMsg);
			RequestDispatcher rd = req.getRequestDispatcher("/StudentAssignment1/RegistrationForm.jsp");
			rd.forward(req, resp);
		}
	}
}