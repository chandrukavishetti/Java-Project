package com.studentcourse.controller;

import java.io.IOException;
import java.util.List;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student-view")
public class ViewStudentsServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("ViewStudentsServlet initialized");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);

		if (session == null) {
			resp.sendRedirect("login");
			return;
		}

		StudentDAO dao = new StudentDAO();

		try {
			List<Student> students = dao.viewStudent();
			req.setAttribute("students", students);
			RequestDispatcher requestdispatcher = req.getRequestDispatcher("/WEB-INF/views/student-list.jsp");
			requestdispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("dashboard");
		}
	}
}