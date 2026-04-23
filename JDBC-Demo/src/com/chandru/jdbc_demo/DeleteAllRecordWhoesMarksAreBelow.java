//12.Delete all students whose marks are below a given threshold.

package com.chandru.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAllRecordWhoesMarksAreBelow {
	public static void main(String[] args) {
		String sql = "delete from students where marks < ?";

		Connection connection;

		try {
			connection = DBConnection.getConnection();

			PreparedStatement preparedstatement = connection.prepareStatement(sql);

			preparedstatement.setInt(1, 30);

			int row = preparedstatement.executeUpdate();

			if (row > 0) {
				System.out.println("deleted successfully");
			} else {
				System.out.println("no such record available");
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

}
