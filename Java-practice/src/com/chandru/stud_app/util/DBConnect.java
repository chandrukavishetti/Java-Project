package com.chandru.stud_app.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/practice";
		String user = "root";
		String password = "cmk26@2004";

		return DriverManager.getConnection(url, user, password);
	}

}
