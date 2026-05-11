package com.chandru.OnlineExamResult3;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/onlineexam")
public class OnlineExamResultPreviewSystem extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("OnlineExamResultPreviewSystem Servlet Initialized");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Redirect to form on GET request
		resp.sendRedirect("/OnlineExamResult3/examForm.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("studentName");
		String rollStr = req.getParameter("rollNumber");
		String sub1Str = req.getParameter("subj1");
		String sub2Str = req.getParameter("subj2");
		String sub3Str = req.getParameter("subj3");

		boolean isValid = true;
		String errorMsg = "";

		int rollNumber = 0;
		int subject1 = 0, subject2 = 0, subject3 = 0;

		if (name == null || name.trim().isEmpty()) {
			isValid = false;
			errorMsg = "Student Name is required";
		}

		if (rollStr == null || rollStr.trim().isEmpty()) {
			isValid = false;
			errorMsg = "Roll Number is required";
		} else {
			try {
				rollNumber = Integer.parseInt(rollStr);
				if (rollNumber <= 0) {
					isValid = false;
					errorMsg = "Roll Number must be positive";
				}
			} catch (NumberFormatException e) {
				isValid = false;
				errorMsg = "Invalid Roll Number";
			}
		}

		try {
			subject1 = Integer.parseInt(sub1Str);
			if (subject1 < 0 || subject1 > 100) {
				isValid = false;
				errorMsg = "Subject 1 marks must be between 0 and 100";
			}
		} catch (NumberFormatException e) {
			isValid = false;
			errorMsg = "Subject 1 marks must be numeric";
		}

		try {
			subject2 = Integer.parseInt(sub2Str);
			if (subject2 < 0 || subject2 > 100) {
				isValid = false;
				errorMsg = "Subject 2 marks must be between 0 and 100";
			}
		} catch (NumberFormatException e) {
			isValid = false;
			errorMsg = "Subject 2 marks must be numeric";
		}

		try {
			subject3 = Integer.parseInt(sub3Str);
			if (subject3 < 0 || subject3 > 100) {
				isValid = false;
				errorMsg = "Subject 3 marks must be between 0 and 100";
			}
		} catch (NumberFormatException e) {
			isValid = false;
			errorMsg = "Subject 3 marks must be numeric";
		}

		if (isValid) {
			int totalMarks = subject1 + subject2 + subject3;
			double percentage = (totalMarks / 300.0) * 100;

			String resultStatus;
			if (percentage >= 75) {
				resultStatus = "Distinction";
			} else if (percentage >= 60) {
				resultStatus = "First Class";
			} else if (percentage >= 40) {
				resultStatus = "Pass";
			} else {
				resultStatus = "Fail";
			}

			req.setAttribute("studentName", name);
			req.setAttribute("rollNumber", rollNumber);
			req.setAttribute("subj1", subject1);
			req.setAttribute("subj2", subject2);
			req.setAttribute("subj3", subject3);
			req.setAttribute("totalMarks", totalMarks);
			req.setAttribute("percentage", String.format("%.2f", percentage));
			req.setAttribute("resultStatus", resultStatus);

			RequestDispatcher rd = req.getRequestDispatcher("/OnlineExamResult3/resultPreviewPage.jsp");
			rd.forward(req, resp);

		} else {
			// Send error back to form
			req.setAttribute("errorMsg", errorMsg);
			RequestDispatcher rd = req.getRequestDispatcher("/OnlineExamResult3/examForm.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	public void destroy() {
		System.out.println("OnlineExamResultPreviewSystem Servlet Destroyed");
	}
}

//package com.chandru.OnlineExamResult3;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet(value = "/onlineexam")
//public class OnlineExamResultPreviewSystem extends HttpServlet {
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		// super.doGet(req, resp);
//		resp.sendRedirect("OnlineExamResult3/examForm.jsp");
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		// super.doPost(req, resp);
//		String name = req.getParameter("studentName");
//		String rollStr = req.getParameter("rollNumber");
//		String sub1 = req.getParameter("subj1");
//		String sub2 = req.getParameter("subj2");
//		String sub3 = req.getParameter("subj3");
//
//		boolean isValid = true;
//		String errorMsg = "";
//		int subject1,subject2,subject3;
//
//		if (name == null || name.trim().isEmpty()) {
//			isValid = false;
//			errorMsg = "Student Name is required";
//		}
//		try {
//			int roll = Integer.parseInt(rollStr);
//			if (roll < 0) {
//				isValid = false;
//				errorMsg = "roll number cannot be negativ";
//			}
//		} catch (NumberFormatException e) {
//			isValid = false;
//			errorMsg = "enter the valid roll number";
//		}
//
//		try {
//			subject1 = Integer.parseInt(sub1);
//			if (subject1 < 0 || subject1 > 100) {
//				isValid = false;
//				errorMsg = "enter the subject1 marks between 0 to 100";
//			}
//		} catch (NumberFormatException e) {
//			isValid = false;
//			errorMsg = "enter the valid 0 to 100 marks";
//		}
//		try {
//		 subject2 = Integer.parseInt(sub1);
//			if (subject2 < 0 || subject2 > 100) {
//				isValid = false;
//				errorMsg = "enter the subject2 marks between 0 to 100";
//			}
//		} catch (NumberFormatException e) {
//			isValid = false;
//			errorMsg = "enter the valid 0 to 100 marks";
//		}
//		try {
//			 subject3 = Integer.parseInt(sub1);
//			if (subject3 < 0 || subject3 > 100) {
//				isValid = false;
//				errorMsg = "enter the subject3 marks between 0 to 100";
//			}
//		} catch (NumberFormatException e) {
//			isValid = false;
//			errorMsg = "enter the valid 0 to 100 marks";
//		}
//		
//		
//		if (isValid) {
//			PrintWriter out=resp.getWriter();
//			
//			
//			if(subject1<40 || subject2||<40 ||subject3<40) {
//			out.println(" you are faild student");
//			RequestDispatcher rd=req.getRequestDispatcher("OnlineExamResutl3/resultPreviewPage.jsp      ")
//					rd.forward(req, resp);
//			}
//			
//			double calculation=subject1+subject3+subject3/300*100;
//			
//			out.println("your score is "+calculation);
//			
//			req.setAttribute(studentName, name);
//			req.setAttribute(rollNumber, rollStr);
//			req.setAttribute(subj1, sub1);
//			req.setAttribute(subj2, sub2);
//			req.setAttribute(subj3, sub3);
//
//			RequestDispatcher rd = req.getRequestDispatcher("OnlineExamResult3/resultPreviewPage.jsp");
//			rd.forward(req, resp);
//		} else {
//			req.setAttribute(errorMsg, errorMsg);
//			RequestDispatcher rd = req.getRequestDispatcher("OnlineExamResult3/examForm.jsp");
//			rd.forward(req, resp);
//		}
//	}
//
//}
