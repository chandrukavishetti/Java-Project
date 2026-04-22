//4.Fetch and display a student record based on a given id.

package com.chandru.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayAccordingToGivenId {
	public static void main(String[] args) {
		String sql = "select * from students where id=(?)";

		Connection connection;

		try {
			connection = DBConnection.getConnection();

			PreparedStatement preparedstatement = connection.prepareStatement(sql);

			preparedstatement.setInt(1, 3);

			ResultSet resultset = preparedstatement.executeQuery();

			if (resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				int age = resultset.getInt("age");
				String branch = resultset.getString("branch");
				double marks = resultset.getDouble("marks");

				System.out.println("id : " + id + " | name : " + name + " | age : " + age + " | branch : " + branch
						+ " | marks : " + marks);
			} else {
				System.out.println("no such id record is found ");
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

}
