// 7.Display students whose age lies between two given values.

package com.chandru.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentAgeLiesBetween {
	public static void main(String[] args) {
		String sql = "select * from students where age between ? and ? ";

		Connection connection;

		try {
			connection = DBConnection.getConnection();

			PreparedStatement preparedstatement = connection.prepareStatement(sql);

			preparedstatement.setInt(1, 30);
			preparedstatement.setInt(2, 40);

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

			resultset.close();
			preparedstatement.close();
			connection.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

}
