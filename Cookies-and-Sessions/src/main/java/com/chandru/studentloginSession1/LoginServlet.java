package com.chandru.studentloginSession1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if ("student".equals(username) && "student123".equals(password)) {

			HttpSession session = req.getSession(true);
			session.setAttribute("username", username);
			session.setMaxInactiveInterval(30 * 60);

			resp.sendRedirect(req.getContextPath() + "/dashboard");
		} else {
			resp.setContentType("text/html");
			resp.getWriter().println("<h3 style='color:red'>Invalid credentials! Try again.</h3>");
			req.getRequestDispatcher("studentloginSession1/login.html").forward(req, resp);
		}
	}
}