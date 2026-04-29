package com.chandru.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get data from form
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String dept = request.getParameter("dept");
		String fees = request.getParameter("fees");

		// Set response type
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		// Display output
		out.println("<h2>Student Details Submitted</h2>");
		out.println("ID: " + id + "<br>");
		out.println("Name: " + name + "<br>");
		out.println("Dept: " + dept + "<br>");
		out.println("Fees: " + fees + "<br>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}