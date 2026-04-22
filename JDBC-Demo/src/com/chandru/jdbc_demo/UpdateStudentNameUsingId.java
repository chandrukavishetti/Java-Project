// 8.Update the name of a student using their id.

package com.chandru.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateStudentNameUsingId {
	public static void main(String[] args) {
		String sql = "update students set name=? where id=?";

		Connection connection;

		try {
			connection = DBConnection.getConnection();

			PreparedStatement preparedstatement = connection.prepareStatement(sql);

			preparedstatement.setString(1, "pruthviraj");
			preparedstatement.setInt(2, 2);

			int row = preparedstatement.executeUpdate();

			if (row > 0) {
				System.out.println("student recode updated successfully");
			} else {
				System.out.println("no such id found in the student table");
			}

			preparedstatement.close();
			connection.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

}
