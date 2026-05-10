package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.studentcourse.model.Registration;
import com.studentcourse.util.DBConnection;

public class RegistrationDAO {

	public boolean registerStudent(int studentId, int courseId, LocalDate registrationDate) throws Exception {
		String sql = "insert into registrations(student_id, course_id, registration_date) values(?,?,?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, studentId);
			ps.setInt(2, courseId);
			ps.setDate(3, java.sql.Date.valueOf(registrationDate));

			int rows = ps.executeUpdate();
			return rows > 0;
		}
	}

	public List<Registration> getAllRegistrations() throws Exception {
		String sql = "SELECT r.student_id, r.course_id, r.registration_date, r.status, "
				+ "s.student_name, s.email, s.phone, s.age, s.city, "
				+ "c.course_name, c.duration, c.fees, c.trainer_name " + "FROM registrations r "
				+ "JOIN students s ON r.student_id = s.student_id " + "JOIN courses c ON r.course_id = c.course_id";

		List<Registration> registrations = new ArrayList<>();

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Registration reg = new Registration(rs.getInt("student_id"), rs.getInt("course_id"),
						rs.getDate("registration_date").toLocalDate(), rs.getString("status"),
						rs.getString("student_name"), rs.getString("email"), rs.getString("phone"), rs.getInt("age"),
						rs.getString("city"), rs.getString("course_name"), rs.getInt("duration"), rs.getDouble("fees"),
						rs.getString("trainer_name"));
				registrations.add(reg);
			}
		}
		return registrations;
	}

	public boolean updateRegistrationStatus(int studentId, int courseId, String status) throws Exception {
		String sql = "update registrations set status=? where student_id=? and course_id=?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, status);
			ps.setInt(2, studentId);
			ps.setInt(3, courseId);

			int rows = ps.executeUpdate();
			return rows > 0;
		}
	}

	public boolean deleteRegistration(int studentId, int courseId) throws Exception {
		String sql = "delete from registrations where student_id=? and course_id=?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, studentId);
			ps.setInt(2, courseId);

			int rows = ps.executeUpdate();
			return rows > 0;
		}
	}
}