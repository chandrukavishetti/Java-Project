package com.chandru.assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/courses")
public class CourseCatelogViewer extends HttpServlet {

	private static HashMap<String, String[]> courseslist = new HashMap<>();

	static {
		courseslist.put("cs", new String[] { "DSA", "DBMS", "CN" });
		courseslist.put("me", new String[] { "Mechanical Design", "Thermal and Fluids", "Manufacturing",
				"Robotics and Automation", "Automobile Engineering" });
		courseslist.put("ee", new String[] { "Circuit Theory", "Electrical Machines", "Power Electronics",
				"Control Systems", "Electromagnetism" });
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String department = req.getParameter("department");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<h2>Course Details</h2>");

		if (department == null || department.trim().isEmpty()) {
			out.println("<p style='color:red;'>Department cannot be empty!</p>");
			return;
		}

		department = department.toLowerCase();

		if (!courseslist.containsKey(department)) {
			out.println("<p style='color:red;'>Invalid department! No courses found.</p>");
			return;
		}

		String[] courses = courseslist.get(department);

		out.println("<p>Department: " + department.toUpperCase() + "</p>");
		out.println("<h3>Available Courses:</h3>");
		out.println("<ul>");

		for (String c : courses) {
			out.println("<li>" + c + "</li>");
		}

		out.println("</ul>");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}
}