//11.Delete a student record using their id.

package com.chandru.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStudentRecordUsingId {
	public static void main(String[] args) {
		String sql = "delete from students where id=?";

		Connection connection;

		try {
			connection = DBConnection.getConnection();

			PreparedStatement preparedstatement = connection.prepareStatement(sql);

			preparedstatement.setInt(1, 16);

			int row = preparedstatement.executeUpdate();

			if (row > 0) {
				System.out.println("deleted successfully");
			} else {
				System.out.println("no such id is present in the table");
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

}
