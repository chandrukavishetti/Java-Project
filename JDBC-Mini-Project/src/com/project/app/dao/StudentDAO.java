package com.project.app.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.project.app.model.Student;
import com.project.app.util.DBUtil;

public class StudentDAO {

	public boolean addStudent(Student s) throws Exception {
		String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {

			preparedstatement.setInt(1, s.getId());
			preparedstatement.setString(2, s.getName());
			preparedstatement.setInt(3, s.getAge());
			preparedstatement.setString(4, s.getBranch());

			return preparedstatement.executeUpdate() > 0;
		}
	}

	public boolean studentExists(int id) throws Exception {
		String sql = "SELECT * FROM student WHERE id=?";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {

			preparedstatement.setInt(1, id);
			ResultSet resultset = preparedstatement.executeQuery();
			return resultset.next();
		}
	}

	public boolean updateStudent(int id, String name, String branch) throws Exception {
		String sql = "UPDATE student SET name=?, branch=? WHERE id=?";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {

			preparedstatement.setString(1, name);
			preparedstatement.setString(2, branch);
			preparedstatement.setInt(3, id);

			return preparedstatement.executeUpdate() > 0;
		}
	}

	public boolean deleteStudent(int id) throws Exception {
		String deleteReg = "DELETE FROM registration WHERE student_id=?";
		String deleteStudent = "DELETE FROM student WHERE id=?";

		try (Connection connection = DBUtil.getConnection()) {
			connection.setAutoCommit(false);

			try (PreparedStatement preparedstatement1 = connection.prepareStatement(deleteReg);
					PreparedStatement preparedstatement2 = connection.prepareStatement(deleteStudent)) {
				preparedstatement1.setInt(1, id);
				preparedstatement1.executeUpdate();

				preparedstatement2.setInt(1, id);
				int rows = preparedstatement2.executeUpdate();

				if (rows == 0)
					throw new Exception("Student not found");

				connection.commit();
				return true;

			} catch (Exception e) {
				connection.rollback();
				throw e;
			}
		}
	}

	public List<String> getLookupItems(String table, String column) throws Exception {
		List<String> list = new ArrayList<>();
		String sql = "SELECT " + column + " FROM " + table;
		try (Connection connection = com.project.app.util.DBUtil.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql);
				ResultSet resultset = preparedstatement.executeQuery()) {
			while (resultset.next()) {
				list.add(resultset.getString(1));
			}
		}
		return list;
	}
}