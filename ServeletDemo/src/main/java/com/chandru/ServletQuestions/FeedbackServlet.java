package com.chandru.ServletQuestions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {

	private ArrayList<String> list = new ArrayList<>();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idStr = req.getParameter("id");
		String ratingStr = req.getParameter("rating");
		String review = req.getParameter("review");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<h2>Product Feedback Result</h2>");

		boolean isValid = true;

		int id = 0;
		int rating = 0;

		try {
			id = Integer.parseInt(idStr);
			if (id <= 0) {
				out.println("<p style='color:red;'>ID must be positive!</p>");
				isValid = false;
			}
		} catch (Exception e) {
			out.println("<p style='color:red;'>Invalid Product ID!</p>");
			isValid = false;
		}

		try {
			rating = Integer.parseInt(ratingStr);
			if (rating < 1 || rating > 5) {
				out.println("<p style='color:red;'>Rating must be between 1 and 5!</p>");
				isValid = false;
			}
		} catch (Exception e) {
			out.println("<p style='color:red;'>Invalid Rating!</p>");
			isValid = false;
		}

		if (review == null || review.trim().isEmpty()) {
			out.println("<p style='color:red;'>Review cannot be empty!</p>");
			isValid = false;
		}

		if (isValid) {
			list.add("Product ID: " + id + ", Rating: " + rating + ", Review: " + review);

			out.println("<h3 style='color:green;'>Thank you for your feedback!</h3>");
			out.println("<p><b>Product ID:</b> " + id + "</p>");
			out.println("<p><b>Rating:</b> " + rating + "</p>");
			out.println("<p><b>Review:</b> " + review + "</p>");

			out.println("<h3>All Feedbacks:</h3>");
			out.println("<ul>");

			for (String fb : list) {
				out.println("<li>" + fb + "</li>");
			}

			out.println("</ul>");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}
}