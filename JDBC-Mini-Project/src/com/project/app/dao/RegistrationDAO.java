package com.project.app.dao;

import java.sql.*;
import com.project.app.util.DBUtil;

public class RegistrationDAO {

	public boolean registerCourse(int studentId, String course, double fee) throws Exception {

		String check = "SELECT * FROM registration WHERE student_id=? AND course_name=?";
		String insert = "INSERT INTO registration(student_id, course_name, fees_paid) VALUES (?, ?, ?)";

		try (Connection connection = DBUtil.getConnection()) {
			connection.setAutoCommit(false);

			try (PreparedStatement preparedstatement1 = connection.prepareStatement(check);
					PreparedStatement preparedstatement2 = connection.prepareStatement(insert)) {
				preparedstatement1.setInt(1, studentId);
				preparedstatement1.setString(2, course);
				ResultSet resultset = preparedstatement1.executeQuery();

				if (resultset.next()) {
					System.out.println("Already registered!");
					return false;
				}

				preparedstatement2.setInt(1, studentId);
				preparedstatement2.setString(2, course);
				preparedstatement2.setDouble(3, fee);
				preparedstatement2.executeUpdate();

				connection.commit();
				return true;

			} catch (Exception e) {
				connection.rollback();
				throw e;
			}
		}
	}

	public void viewAll() throws Exception {
		String sql = "SELECT s.id, s.name, s.branch, r.course_name, r.fees_paid "
				+ "FROM student s LEFT JOIN registration r ON s.id = r.student_id";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql);
				ResultSet resultset = preparedstatement.executeQuery()) {

			boolean found = false;
			while (resultset.next()) {
				found = true;
				System.out.println(resultset.getInt(1) + " | " + resultset.getString(2) + " | " + resultset.getString(3)
						+ " | " + resultset.getString(4) + " | " + resultset.getDouble(5));
			}
			if (!found) {
				System.out.println("no student available table is empty ");
			}
		}
	}

	public void searchById(int id) throws Exception {
		String sql = "SELECT s.*, r.course_name, r.fees_paid FROM student s "
				+ "LEFT JOIN registration r ON s.id=r.student_id WHERE s.id=?";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {

			preparedstatement.setInt(1, id);
			ResultSet resultset = preparedstatement.executeQuery();

			boolean found = false;
			while (resultset.next()) {
				found = true;
				System.out.println(resultset.getInt("id") + " | " + resultset.getString("name") + " | "
						+ resultset.getString("branch") + " | " + resultset.getString("course_name") + " | "
						+ resultset.getDouble("fees_paid"));
			}

			if (!found)
				System.out.println("No data found");
		}
	}

	public boolean updateFee(int id, String course, double fee) throws Exception {
		String sql = "UPDATE registration SET fees_paid=? WHERE student_id=? AND course_name=?";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {

			preparedstatement.setDouble(1, fee);
			preparedstatement.setInt(2, id);
			preparedstatement.setString(3, course);

			return preparedstatement.executeUpdate() > 0;
		}
	}

	public boolean cancelRegistration(int id, String course) throws Exception {
		String sql = "DELETE FROM registration WHERE student_id=? AND course_name=?";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {

			preparedstatement.setInt(1, id);
			preparedstatement.setString(2, course);

			return preparedstatement.executeUpdate() > 0;
		}
	}

	public void highPaying(double amount) throws Exception {
		String sql = "SELECT DISTINCT s.name, r.fees_paid FROM student s "
				+ "JOIN registration r ON s.id=r.student_id WHERE r.fees_paid>?";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {

			preparedstatement.setDouble(1, amount);
			ResultSet resultset = preparedstatement.executeQuery();

			boolean found = false;
			while (resultset.next()) {
				found = true;
				System.out.println(resultset.getString(1) + " | " + resultset.getDouble(2));
			}
			if (!found) {
				System.out.println("no such high paying available greater than the : " + amount);
			}
		}
	}

	public void courseWiseCount() throws Exception {
		String sql = "SELECT course_name, COUNT(*) FROM registration GROUP BY course_name";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet resultset = ps.executeQuery()) {

			while (resultset.next()) {
				System.out.println(resultset.getString(1) + " -> " + resultset.getInt(2));
			}
		}
	}
}