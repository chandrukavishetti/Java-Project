package com.chandru.EmployeeLeaveApplication2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/leave")
public class LeaveServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {

		System.out.println("LeaveServlet Initialized");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("empName");
		String id = req.getParameter("empId");
		String dept = req.getParameter("department");
		String type = req.getParameter("leaveType");
		String daysStr = req.getParameter("leaveDays");
		String reason = req.getParameter("reason");

		System.out.println("doPost method called");

		int days = 0;

		try {
			days = Integer.parseInt(daysStr);
		} catch (Exception e) {
			days = 0;
		}
		System.out.println("Name: " + name);
		System.out.println("Reason length: " + reason.length());
		System.out.println("Days: " + days);

		if (name.isEmpty() || id.isEmpty() || dept.isEmpty() || type == null || days < 1 || days > 10
				|| reason.length() < 10) {
			if (reason.length() < 10) {
				System.out.println("give the reason that should be above 10 charecter");
			}
			System.out.println("Validation Failed");
			resp.sendRedirect("EmployeeLeaveApplication2/LeaveForm.jsp");
			return;
		}

		String message;
		if (days > 5) {
			message = "Manager Approval Required";
		} else {
			message = "Leave Approved";
		}

		try {
			Connection con = DBConnection.getConnection();

			if (con == null) {
				System.out.println(" Connection is NULL");
				return;
			}
			String sql = "INSERT INTO leave_applications "
					+ "(emp_name, emp_id, department, leave_type, leave_days, reason) " + "VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, name);
			ps.setString(2, id);
			ps.setString(3, dept);
			ps.setString(4, type);
			ps.setInt(5, days);
			ps.setString(6, reason);

			int rows = ps.executeUpdate();

			System.out.println("Rows inserted: " + rows);
			ps.close();
			con.close();

			System.out.println(" Data Inserted Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}

		req.setAttribute("name", name);
		req.setAttribute("id", id);
		req.setAttribute("dept", dept);
		req.setAttribute("type", type);
		req.setAttribute("days", days);
		req.setAttribute("reason", reason);
		req.setAttribute("message", message);

		req.getRequestDispatcher("EmployeeLeaveApplication2/Review.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("LeaveServlet Destroyed");
	}
}
