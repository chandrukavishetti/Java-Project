package com.chandru.EmployeeLeaveApplication2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
	private static final String USER = "root";
	private static final String PASSWORD = "cmk26@2004";

	public static Connection getConnection() throws ClassNotFoundException {

		Connection con = null;

		try {
			// Load MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(URL, USER, PASSWORD);

			System.out.println(" Database Connected Successfully");

		} catch (SQLException e) {
			System.out.println(" Connection Failed");
			e.printStackTrace();
		}

		return con;
	}
}
