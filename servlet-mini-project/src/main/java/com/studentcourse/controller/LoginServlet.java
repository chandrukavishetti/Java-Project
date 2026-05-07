package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.AdminDAO;
import com.studentcourse.model.Admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login-action")
public class LoginServlet extends HttpServlet {

	@Override
	public void init() {
		System.out.println("LoginServlet initialized");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");

		if (username.isEmpty() || password.isEmpty()) {
			req.setAttribute("error", "Username and Password required");
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
			rd.forward(req, resp);
			return;
		}

		Admin admin = new Admin(username, password);

		AdminDAO dao = new AdminDAO();

		try {
			boolean status = dao.adminLogin(admin);
			if (status) {
				HttpSession session = req.getSession();
				session.setAttribute("loggedInUser", username);

				// COOKIE
				if (remember != null) {
					Cookie cookie = new Cookie("rememberedUsername", username);
					cookie.setMaxAge(60 * 60 * 24);
					resp.addCookie(cookie);
				} else {
					Cookie cookie = new Cookie("rememberedUsername", "");
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
				}
				resp.sendRedirect("dashboard");
			} else {
				req.setAttribute("error", "Invalid Username or Password");
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		System.out.println("LoginServlet destroyed");
	}
}