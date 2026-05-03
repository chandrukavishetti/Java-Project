package com.chandru.ServletQuestions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/resume")
public class ResumeUploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String resume = req.getParameter("resume");
		String skills = req.getParameter("skills");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<h2>Resume Preview</h2>");

		boolean isValid = true;

		if (name == null || name.trim().isEmpty()) {
			out.println("<p style='color:red;'>Name cannot be empty!</p>");
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

		if (skills == null || skills.trim().isEmpty()) {
			out.println("<p style='color:red;'>At least one skill required!</p>");
			isValid = false;
		}

		if (isValid) {

			String[] skillList = skills.split(",");

			out.println("<h3 style='color:green;'>Resume Submitted Successfully!</h3>");

			out.println("<p><b>Name:</b> " + name + "</p>");
			out.println("<p><b>Email:</b> " + email + "</p>");

			out.println("<p><b>Summary:</b> " + resume + "</p>");

			out.println("<p><b>Skills:</b></p>");
			out.println("<ul>");

			for (String s : skillList) {
				out.println("<li>" + s.trim() + "</li>");
			}

			out.println("</ul>");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}
}