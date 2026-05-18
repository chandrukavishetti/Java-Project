package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.CourseDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/course-delete")
public class DeleteCourseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {
			resp.sendRedirect("login");
			return;
		}

		String courseIdStr = req.getParameter("id");

		if (courseIdStr == null || courseIdStr.isEmpty()) {
			session.setAttribute("error", "Invalid course ID");
			resp.sendRedirect("view-courses");
			return;
		}

		int courseId = Integer.parseInt(courseIdStr);
		CourseDAO dao = new CourseDAO();

		try {
			// Check whether course has registrations
			boolean hasRegistrations = dao.hasRegistrations(courseId);

			if (hasRegistrations) {
				// If registrations exist: Do not delete, redirect with error
				session.setAttribute("error",
						"Cannot delete course because students are already enrolled. Please delete all registrations for this course first.");
				resp.sendRedirect("view-courses");
				return;
			}

			// If no registrations: Delete course
			boolean status = dao.deleteCourse(courseId);

			if (status) {
				session.setAttribute("message", "Course deleted successfully");
			} else {
				session.setAttribute("error", "Failed to delete course");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("error", "Error deleting course");
		}

		resp.sendRedirect("view-courses");
	}
}