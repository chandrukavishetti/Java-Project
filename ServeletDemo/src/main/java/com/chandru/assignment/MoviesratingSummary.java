package com.chandru.assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/rating")
public class MoviesratingSummary extends HttpServlet {

	public static HashMap<String, String[]> movies = new HashMap<>();

	static {
		movies.put("kgf", new String[] { "8.5", "Action, Emotional (Mother sentiment)" });
		movies.put("rrr", new String[] { "9.0", "Patriotic, Action" });
		movies.put("inception", new String[] { "9.2", "Sci-Fi, Thriller" });
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String movieName = req.getParameter("movie");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<h2>Movie Rating Summary</h2>");

		if (movieName == null || movieName.trim().isEmpty()) {
			out.println("<p style='color:red;'>Movie cannot be empty!</p>");
			return;
		}

		movieName = movieName.toLowerCase();

		if (!movies.containsKey(movieName)) {
			out.println("<p style='color:red;'>Invalid Movie! No data found.</p>");
			return;
		}

		String[] data = movies.get(movieName);

		out.println("<p><b>Movie:</b> " + movieName.toUpperCase() + "</p>");
		out.println("<p><b>Rating:</b> " + data[0] + "</p>");
		out.println("<p><b>Genre/Review:</b> " + data[1] + "</p>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}
}