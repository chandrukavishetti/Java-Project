package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update-course")
public class UpdateCourseServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("UpdateCourseServlet Initialized");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET request received - Redirecting to courses list");
		resp.sendRedirect("view-courses");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost method called");

		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {
			resp.sendRedirect("login");
			return;
		}

		int courseId = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int duration = Integer.parseInt(req.getParameter("duration"));
		float fees = Float.parseFloat(req.getParameter("fees"));
		String trainername = req.getParameter("trainername");

		System.out.println("Updating course - ID: " + courseId + ", Name: " + name);

		if (name.isEmpty() || trainername.isEmpty()) {
			session.setAttribute("error", "All fields are required");
			resp.sendRedirect("course-edit?id=" + courseId);
			return;
		}

		if (duration <= 0) {
			session.setAttribute("error", "Duration must be greater than 0");
			resp.sendRedirect("course-edit?id=" + courseId);
			return;
		}

		if (fees < 0) {
			session.setAttribute("error", "Fees cannot be negative");
			resp.sendRedirect("course-edit?id=" + courseId);
			return;
		}

		Course course = new Course(courseId, name, duration, fees, trainername);
		CourseDAO dao = new CourseDAO();

		try {
			boolean status = dao.updateCourse(course);
			if (status) {
				session.setAttribute("message", "Course updated successfully");
				System.out.println("Course updated successfully");
			} else {
				session.setAttribute("error", "Failed to update course");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Error updating course");
		}

		resp.sendRedirect("view-courses");
	}
}