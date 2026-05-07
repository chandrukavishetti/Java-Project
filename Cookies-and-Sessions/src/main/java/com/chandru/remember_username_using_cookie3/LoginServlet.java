package com.chandru.remember_username_using_cookie3;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String remember = req.getParameter("remember");

		if (remember != null) {
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(60 * 60 * 24 * 7); // 7 days
			resp.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("username", "");
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}

		// Redirect instead of printing
		resp.sendRedirect("remember_username_using_cookie3/login.jsp?msg=success");
	}
}