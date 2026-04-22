package com.chandru.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayAllRecords {
	public static void main(String[] args) {
		String sql = "select * from students";

		Connection connection;
		try {
			connection = DBConnection.getConnection();

			PreparedStatement preparedstatement = connection.prepareStatement(sql);

			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				int age = resultset.getInt("age");
				String branch = resultset.getString("branch");
				double marks = resultset.getDouble("marks");

				System.out.println(id + " | " + name + " | " + age + " | " + branch + " | " + marks + " | ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
