package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({ "/student-form", "/student-add" })
public class AddStudentServlet extends HttpServlet {

	@Override
	public void init() {
		System.out.println("AddStudentServlet initialized");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null) {
			resp.sendRedirect("login");
			return;
		}
		RequestDispatcher requestdispatcher = req.getRequestDispatcher("/WEB-INF/views/student-form.jsp");
		requestdispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String ageStr = req.getParameter("age");
		String city = req.getParameter("city");

		if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || city.isEmpty()) {
			req.setAttribute("error", "All fields are required");
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student-form.jsp");
			rd.forward(req, resp);
			return;
		}

		if (!name.matches("^[a-zA-Z\\s]+$")) {
			req.setAttribute("error", "Name must contain only alphabets and spaces");
			req.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(req, resp);
			return;
		}

		if (!city.matches("^[a-zA-Z\\s]+$")) {
			req.setAttribute("error", "City name must contain only alphabets and spaces");
			req.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(req, resp);
			return;
		}

		if (!phone.matches("^[0-9]+$")) {
			req.setAttribute("error", "Phone number must contain only numbers");
			req.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(req, resp);
			return;
		}

		int age = Integer.parseInt(ageStr);

		if (age < 18) {
			req.setAttribute("error", "Age must be 18 or above");
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student-form.jsp");
			rd.forward(req, resp);
			return;
		}

		Student student = new Student(name, email, phone, age, city);

		StudentDAO dao = new StudentDAO();

		try {
			boolean status = dao.addStudent(student);
			if (status) {
				HttpSession session = req.getSession();
				session.setAttribute("message", "Student added successfully");
				resp.sendRedirect("dashboard");
			}
		} catch (Exception e) {
			HttpSession session = req.getSession();
			session.setAttribute("message", "Failed to add student");
			resp.sendRedirect("dashboard");
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		System.out.println("AddStudentServlet destroyed");
	}
}