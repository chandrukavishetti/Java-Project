package com.chandru.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertNewStudent {

	public static void main(String[] args) {

		String sql = "INSERT INTO students (name, age, branch, marks) VALUES (?, ?, ?, ?)";

		try {
			// Get connection from common class
			Connection connection = DBConnection.getConnection();

			PreparedStatement preparedstatement = connection.prepareStatement(sql);

			preparedstatement.setString(1, "Kiran");
			preparedstatement.setInt(2, 22);
			preparedstatement.setString(3, "BCA");
			preparedstatement.setDouble(4, 87.5);

			int rows = preparedstatement.executeUpdate();

			if (rows > 0) {
				System.out.println("Student inserted successfully!");
			}

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}