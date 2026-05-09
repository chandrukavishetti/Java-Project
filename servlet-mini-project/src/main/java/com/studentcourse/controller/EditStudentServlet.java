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

@WebServlet("/student-edit")
public class EditStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {
			resp.sendRedirect("login");
			return;
		}

		String studentIdStr = req.getParameter("id");

		if (studentIdStr == null || studentIdStr.isEmpty()) {
			resp.sendRedirect("student-view");
			return;
		}

		int studentId = Integer.parseInt(studentIdStr);
		StudentDAO dao = new StudentDAO();

		try {
			Student student = dao.getStudentById(studentId);
			if (student != null) {
				req.setAttribute("student", student);
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/student-edit.jsp");
				rd.forward(req, resp);
			} else {
				resp.sendRedirect("student-view");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("student-view");
		}
	}
}