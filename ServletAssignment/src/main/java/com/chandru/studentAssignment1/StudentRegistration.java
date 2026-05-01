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
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		// super.init();
		System.out.println("Student Registration Initialized");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);

		String name = req.getParameter("studentName");
		String email = req.getParameter("email");
		String ageStr = req.getParameter("age");
		String course = req.getParameter("courseName");
		String batch = req.getParameter("batchTime");

		boolean isValid = true;
		String errorMsg = "";

		if (name == null || name.trim().isEmpty()) {
			isValid = false;
			errorMsg = "Student name is Required";
		} else if (email == null || email.trim().isEmpty()) {
			isValid = false;
			errorMsg = "Email is required";
		} else if (ageStr == null || ageStr.trim().isEmpty()) {
			isValid = false;
			errorMsg = "Age is required";
		} else {
			int age = Integer.parseInt(ageStr);
			if (age < 18) {
				isValid = false;
				errorMsg = "Age must be 18 or above";
			}
		}
		if (course == null || course.trim().isEmpty()) {
			isValid = false;
			errorMsg = "please select a course";
		}
		if (batch == null || batch.trim().isEmpty()) {
			isValid = false;
			errorMsg = "please select preferred batch time";
		}
		if (isValid) {
			// valid=forwording to conformation page usig the RequestDispatcher
			req.setAttribute("studentName", name);
			req.setAttribute("email", email);
			req.setAttribute("age", ageStr);
			req.setAttribute("courseName", course);
			req.setAttribute("batchTime", batch);

			RequestDispatcher rd = req.getRequestDispatcher("/StudentAssignment1/confirmation.jsp");
			rd.forward(req, resp);
		} else {
			// invalid=redirect back to form using sendRedirect
			resp.sendRedirect("registrationForm.jsp");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		// super.destroy();
		System.out.println("StudentRegistration destroyed");
	}

}
