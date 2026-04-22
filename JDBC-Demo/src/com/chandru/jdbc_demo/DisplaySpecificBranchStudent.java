//5.Display all students belonging to a specific branch.

package com.chandru.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplaySpecificBranchStudent {
	public static void main(String[] args) {
		String sql = "select * from students where branch = ?";

		Connection connection;

		try {
			connection = DBConnection.getConnection();

			PreparedStatement preparedstatement = connection.prepareStatement(sql);

			preparedstatement.setString(1, "IT");

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
