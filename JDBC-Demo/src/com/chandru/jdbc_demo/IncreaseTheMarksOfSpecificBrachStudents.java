// 10.Increase the marks of all students belonging to a specific branch by a given value.

package com.chandru.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IncreaseTheMarksOfSpecificBrachStudents {
	public static void main(String[] args) {
		String sql = "update students set marks=marks+? where branch=? ";

		Connection connection;

		try {
			connection = DBConnection.getConnection();

			PreparedStatement preparedstatement = connection.prepareStatement(sql);

			preparedstatement.setDouble(1, 10.0);
			preparedstatement.setString(2, "IT");

			int row = preparedstatement.executeUpdate();

			if (row > 0) {
				System.out.println("updated successfully");

				String fetchSql = "select * from students where branch=?";
				PreparedStatement preparedstatement2 = connection.prepareStatement(fetchSql);
				preparedstatement2.setString(1, "IT");

				ResultSet resultset = preparedstatement2.executeQuery();
				
				boolean found=false;
				
				while(resultset.next()) {
					found=true;
					
					int id = resultset.getInt("id");
					String name = resultset.getString("name");
					int age = resultset.getInt("age");
					String branch = resultset.getString("branch");
					double marks = resultset.getDouble("marks");

					System.out.println("Updated Record:");
					System.out.println("id : " + id + " | name : " + name + " | age : " + age + " | branch : " + branch
							+ " | marks : " + marks);
				}
				
				if(!found) {
					System.out.println("no such field available");
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
