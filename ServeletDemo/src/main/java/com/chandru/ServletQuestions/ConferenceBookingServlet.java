package com.chandru.ServletQuestions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/conference")
public class ConferenceBookingServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String seatsStr = req.getParameter("seats");
		String dateStr = req.getParameter("date");
		String sessionType = req.getParameter("session");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<h2>Conference Booking Result</h2>");

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

		if (dateStr == null || dateStr.trim().isEmpty()) {
			out.println("<p style='color:red;'>Date is required!</p>");
			isValid = false;
		}

		if (sessionType == null || sessionType.trim().isEmpty()) {
			out.println("<p style='color:red;'>Please select session type!</p>");
			isValid = false;
		}

		int seats = 0;

		try {
			seats = Integer.parseInt(seatsStr);

			if (seats < 1 || seats > 5) {
				out.println("<p style='color:red;'>Seats must be between 1 and 5!</p>");
				isValid = false;
			}

		} catch (NumberFormatException e) {
			out.println("<p style='color:red;'>Invalid seat input!</p>");
			isValid = false;
		}

		if (isValid) {
			out.println("<h3 style='color:green;'>Booking Confirmed!</h3>");

			out.println("<h3>Ticket Details</h3>");
			out.println("<p><b>Name:</b> " + name + "</p>");
			out.println("<p><b>Email:</b> " + email + "</p>");
			out.println("<p><b>Seats:</b> " + seats + "</p>");
			out.println("<p><b>Date:</b> " + dateStr + "</p>");
			out.println("<p><b>Session:</b> " + sessionType + "</p>");
		} else {
			out.println("<p style='color:orange;'>Booking failed due to invalid entries.</p>");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}
}