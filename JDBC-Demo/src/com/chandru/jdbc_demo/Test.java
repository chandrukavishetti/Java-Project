package com.chandru.jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "cmk26@2004";

		try {
			// 1. create connection
			Connection connection = DriverManager.getConnection(url, user, password);

			// 2. create statement
			// the below line is not recomended because it raise the issue of the sql
			// injection.

			// Statement statement = connection.createStatement();

			// this below statement it will over come from the sql injection and because it
			// will send the compiled query to the database so it is called safer
			String sqlQuery1 = "select * from students";
			PreparedStatement preparedstatement = connection.prepareStatement(sqlQuery1);

			// 3.Excecute Query
			// ResultSet resultset = statement.executeQuery("select * from students");

			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				int age = resultset.getInt("age");
				String branch = resultset.getString("branch");
				double marks = resultset.getDouble("marks");

				System.out.println(id + " " + name + " " + age + " " + branch + " " + marks);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());

		}
	}

}

//1.Insert a new student record into the student table.
//2.Insert 5 student records using batch processing.
//3.Display all records from the student table.
//4.Fetch and display a student record based on a given id.
//5.Display all students belonging to a specific branch.
//6.Display all students whose marks are greater than a given value.
//7.Display students whose age lies between two given values.
//8.Update the name of a student using their id.
//9.Update both branch and marks of a student based on their id.
//10.Increase the marks of all students belonging to a specific branch by a given value.
//11.Delete a student record using their id.
//12.Delete all students whose marks are below a given threshold.