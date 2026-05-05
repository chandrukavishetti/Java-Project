package com.chandru.studentloginSession1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dashboard")
public class DashBoard extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("username") == null) {
			resp.sendRedirect(req.getContextPath() + "/studentloginSession1/login.html");
			return;
		}

		String username = (String) session.getAttribute("username");

		out.println("<!DOCTYPE html><html><head><title>Dashboard</title></head><body>");
		out.println("<h1>Welcome to Dashboard</h1>");
		out.println("<h2>Hello, " + username + "!</h2>");
		out.println("<br><a href='" + req.getContextPath() + "/logout'>Logout</a>");
		out.println("</body></html>");
	}
}