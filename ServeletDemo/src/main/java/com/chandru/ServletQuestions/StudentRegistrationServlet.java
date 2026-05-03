package com.chandru.ServletQuestions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/register")
public class StudentRegistrationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String ageStr = req.getParameter("age");
		String course = req.getParameter("course");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<h2> Registration Result</h2>");

		boolean isValid = true;

		if (name == null || name.trim().isEmpty()) {
			out.println("<p style='color:red'>name cannot be empty</p>");
			isValid = false;
		}

		if (email == null || email.trim().isEmpty()) {
			out.println("<p style='color:red;'>Email cannot be empty!</p>");
			isValid = false;
		} else {
			String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
			if (!Pattern.matches(emailPattern, email)) {
				out.println("<p style='color:red;'>Invalid email format!</p>");
				isValid = false;
			}
		}
		int age;
		try {
			age = Integer.parseInt(ageStr);
			if (age < 18) {
				out.println("<p style='color:red'>age cannot be under 18<p>");
				isValid = false;
			}
		} catch (Exception e) {
			out.println("<p style='color:red'>Invalid age</p>");
			isValid = false;
		}
		if (course == null || course.trim().isEmpty()) {
			out.println("<p style='color:red;'>Course cannot be empty!</p>");
			isValid = false;
		}
		if (isValid) {
			out.println("<p style='color:green'>Registration Successful </p>");
			out.println("<p><b>Name : </b>" + name + " </p>");
			out.println("<p><b>Email : </b>" + email + " </p>");
			out.println("<p><b>age : </b>" + ageStr + " </p>");
			out.println("<p><b>Course : </b>" + course + " </p>");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		doPost(req, resp);
	}

}
