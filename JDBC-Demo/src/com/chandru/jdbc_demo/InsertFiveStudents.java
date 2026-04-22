package com.chandru.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertFiveStudents {

	public static void main(String[] args) {

		String sql = "INSERT INTO students (name, age, branch, marks) VALUES (?, ?, ?, ?)";

		Connection connection = null;

		try {
			connection = DBConnection.getConnection();

			// Disable auto-commit for batch processing
			connection.setAutoCommit(false);

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			String[] names = { "phelps", "virat", "manubhakar", "messi", "chandrashekhar" };
			int[] ages = { 35, 37, 40, 39, 22 };
			String[] branches = { "swimming", "cricket", "shooting", "football", "IT" };
			double[] marks = { 100, 99, 80, 95, 40 };

			for (int i = 0; i < 5; i++) {
				preparedStatement.setString(1, names[i]);
				preparedStatement.setInt(2, ages[i]);
				preparedStatement.setString(3, branches[i]);
				preparedStatement.setDouble(4, marks[i]);

				// VERY IMPORTANT
				preparedStatement.addBatch();
			}

			// Execute batch
			int[] result = preparedStatement.executeBatch();

			// Commit transaction
			connection.commit();

			System.out.println("Inserted " + result.length + " records successfully");

			preparedStatement.close();
			connection.close();

		} catch (SQLException e) {
			try {
				if (connection != null) {
					connection.rollback(); // rollback if error
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}