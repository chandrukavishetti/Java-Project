package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.model.Course;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add-course")
public class AddCourseServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("AddCourseServlet Initialized");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		if (session == null) {
			resp.sendRedirect("login");
			return;
		}
		RequestDispatcher requestdispatcher = req.getRequestDispatcher("/WEB-INF/views/course-form.jsp");
		requestdispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String durationStr = req.getParameter("duration");
		String feesStr = req.getParameter("fees");
		String trainer_name = req.getParameter("trainer_name");

		if (name.isEmpty() || trainer_name.isEmpty()) {
			req.setAttribute("error", "All fields are required");
			RequestDispatcher requestdispatcher = req.getRequestDispatcher("/WEB-INF/views/course-form.jsp");
			requestdispatcher.forward(req, resp);
			return;
		}

		if (!name.matches("^[a-zA-Z\\s]+$")) {
			req.setAttribute("error", "name must contain only alphabets and spaces");
			req.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(req, resp);
			return;
		}

		if (!trainer_name.matches("^[a-zA-Z\\s]+$")) {
			req.setAttribute("error", "trainer name must contain only alphabets and spaces");
			req.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(req, resp);
			return;
		}

		int duration = Integer.parseInt(durationStr);
		if (duration < 0) {
			req.setAttribute("error", "Duration must be more than 1 days");
			RequestDispatcher requestdispatcher = req.getRequestDispatcher("/WEB-INF/views/course-form.jsp");
			requestdispatcher.forward(req, resp);
			return;
		}

		float fees = Float.parseFloat(feesStr);
		if (fees < 0) {
			req.setAttribute("error", "Fees cannot be negative");
			RequestDispatcher requestdispatcher = req.getRequestDispatcher("/WEB-INF/views/course-form.jsp");
			requestdispatcher.forward(req, resp);
			return;
		}
		Course course = new Course(name, duration, fees, trainer_name);

		CourseDAO dao = new CourseDAO();

		try {
			boolean status = dao.addCourse(course);
			if (status) {
				HttpSession session = req.getSession();
				session.setAttribute("message", "Course added successfully");
				resp.sendRedirect("dashboard");
			}
		} catch (Exception e) {
			HttpSession session = req.getSession();
			session.setAttribute("message", "Failed to add Course");
			resp.sendRedirect("dashboard");
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		System.out.println("AddCourseServlet Destroyed");
	}
}
