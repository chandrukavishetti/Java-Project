// 9.Update both branch and marks of a student based on their id.

package com.chandru.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateBranchAndMarksBasedonId {
	public static void main(String[] args) {
		String sql = "update students set branch=?, marks=? where id=?";

		Connection connection;

		try {
			connection = DBConnection.getConnection();

			PreparedStatement preparedstatement = connection.prepareStatement(sql);

			preparedstatement.setString(1, "ITI");
			preparedstatement.setDouble(2, 99.9);
			preparedstatement.setInt(3, 2);

			int row = preparedstatement.executeUpdate();

			if (row > 0) {
				System.out.println("updated successfully");

				String fetchSql = "select * from students where id=?";
				PreparedStatement preparedstatement2 = connection.prepareStatement(fetchSql);
				preparedstatement2.setInt(1, 2);

				ResultSet resultset = preparedstatement2.executeQuery();

				if (resultset.next()) {
					int id = resultset.getInt("id");
					String name = resultset.getString("name");
					int age = resultset.getInt("age");
					String branch = resultset.getString("branch");
					double marks = resultset.getDouble("marks");

					System.out.println("Updated Record:");
					System.out.println("id : " + id + " | name : " + name + " | age : " + age + " | branch : " + branch
							+ " | marks : " + marks);
				}

				resultset.close();
				preparedstatement2.close();
			} else {
				System.out.println("no such id present in the student table");
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}
}
