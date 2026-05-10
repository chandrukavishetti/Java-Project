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

@WebServlet("/course-edit")
public class EditCourseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {
			resp.sendRedirect("login");
			return;
		}

		String courseIdStr = req.getParameter("id");

		if (courseIdStr == null || courseIdStr.isEmpty()) {
			resp.sendRedirect("view-courses");
			return;
		}

		int courseId = Integer.parseInt(courseIdStr);
		CourseDAO dao = new CourseDAO();

		try {
			Course course = dao.getCourseById(courseId);
			if (course != null) {
				req.setAttribute("course", course);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/update-course.jsp");
				rd.forward(req, resp);
			} else {
				resp.sendRedirect("view-courses");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("view-courses");
		}
	}
}