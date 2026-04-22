//6.Display all students whose marks are greater than a given value.

package com.chandru.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MarksGreaterThanGivenValue {
	public static void main(String[] args) {
		String sql = "select * from students where marks > ?";

		Connection connection;

		try {
			connection = DBConnection.getConnection();

			PreparedStatement preparedstatement = connection.prepareStatement(sql);

			preparedstatement.setDouble(1, 60);

			ResultSet resultset = preparedstatement.executeQuery();

			boolean found = false;

			while (resultset.next()) {
				found = true;

				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				int age = resultset.getInt("age");
				String branch = resultset.getString("branch");
				double marks = resultset.getDouble("marks");

				System.out.println("id : " + id + " | name : " + name + " | age : " + age + " | branch : " + branch
						+ " | marks : " + marks);
			}
			if (!found) {
				System.out.println("no such branch record is found ");
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

}
