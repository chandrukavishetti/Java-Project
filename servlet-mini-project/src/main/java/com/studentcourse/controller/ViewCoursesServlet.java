package com.studentcourse.controller;

import java.io.IOException;
import java.util.List;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.model.Course;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/view-courses")
public class ViewCoursesServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("ViewCoursesServlet Initialized");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {
			resp.sendRedirect("login");
			return;
		}

		CourseDAO dao = new CourseDAO();

		try {
			List<Course> courses = dao.getAllCourses();
			req.setAttribute("courses", courses);
			RequestDispatcher requestdispatcher = req.getRequestDispatcher("/WEB-INF/views/course-list.jsp");
			requestdispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("dashboard");
		}
	}
}