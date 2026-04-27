package com.chandru.stud_app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chandru.stud_app.model.Student;
import com.chandru.stud_app.util.DBConnect;

public class StudentDAO {

	public boolean addStudent(Student s) throws Exception {
		String sql = "insert into student values (?,?,?,?,?)";

		try (Connection connection = DBConnect.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {

			preparedstatement.setInt(1, s.getId());
			preparedstatement.setString(2, s.getName());
			preparedstatement.setDouble(3, s.getMarks());
			preparedstatement.setInt(4, s.getAge());
			preparedstatement.setString(5, s.getBranch());

			return preparedstatement.executeUpdate() > 0;
		}
	}

	public void viewAll() throws Exception {
		String sql = "select * from student";

		try (Connection connection = DBConnect.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql);
				ResultSet resultset = preparedstatement.executeQuery()) {

			boolean found = false;
			while (resultset.next()) {
				found = true;
				System.out.println(resultset.getInt(1) + " | " + resultset.getString(2) + " | " + resultset.getDouble(3)
						+ " | " + resultset.getInt(4) + " | " + resultset.getString(5));
			}
			if (!found) {
				System.out.println("student is not available table is empty");
			}
		}
	}

	public boolean updateStudent(int id, String name, int age, double marks, String branch) throws Exception {
		String sql = "update student set name=?, age=?,marks=?,branch=? where student_id=?";

		try (Connection connection = DBConnect.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {
			preparedstatement.setString(1, name);
			preparedstatement.setInt(2, age);
			preparedstatement.setDouble(3, marks);
			preparedstatement.setString(4, branch);
			preparedstatement.setInt(5, id);

			return preparedstatement.executeUpdate() > 0;

		}
	}

	public boolean deleteStudentById(int id) throws Exception {
		String sql = "delete from student where student_id=?";

		try (Connection connection = DBConnect.getConnection()) {
			connection.setAutoCommit(false);

			try (PreparedStatement preparedstatement = connection.prepareStatement(sql)) {
				preparedstatement.setInt(1, id);
				int row = preparedstatement.executeUpdate();

				if (row == 0) {
					throw new Exception("student not found");
				}
				connection.commit();
				return true;
			} catch (Exception e) {
				connection.rollback();
				throw e;
			}
		}
	}
}
