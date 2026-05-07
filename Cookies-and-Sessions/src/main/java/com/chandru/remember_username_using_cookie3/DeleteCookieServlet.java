package com.chandru.remember_username_using_cookie3;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/delete-cookie")
public class DeleteCookieServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie cookie = new Cookie("username", "");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);

		resp.sendRedirect("remember_username_using_cookie3/login.jsp");
	}
}