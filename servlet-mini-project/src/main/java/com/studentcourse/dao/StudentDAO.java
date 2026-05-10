package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentcourse.model.Student;
import com.studentcourse.util.DBConnection;

public class StudentDAO {

	public boolean addStudent(Student s) throws Exception {

		String sql = "insert into students(student_name,email,phone,age,city) values(?,?,?,?,?)";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {

			preparedstatement.setString(1, s.getName());
			preparedstatement.setString(2, s.getEmail());
			preparedstatement.setString(3, s.getPhone());
			preparedstatement.setInt(4, s.getAge());
			preparedstatement.setString(5, s.getCity());

			int rows = preparedstatement.executeUpdate();

			return rows > 0;
		}
	}

	public boolean deleteStudent(Student s) throws Exception {
		String sql = "delete from students where student_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {
			preparedstatement.setInt(1, s.getId());

			int rows = preparedstatement.executeUpdate();

			return rows > 0;
		}
	}

	public List<Student> viewStudent() throws Exception {
		String sql = "select * from students";
		List<Student> students = new ArrayList<>();

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql);
				ResultSet resultset = preparedstatement.executeQuery()) {

			while (resultset.next()) {
				Student s = new Student(resultset.getInt("student_id"), resultset.getString("student_name"),
						resultset.getString("email"), resultset.getString("phone"), resultset.getInt("age"),
						resultset.getString("city"));
				students.add(s);
			}
		}
		return students;
	}

	public Student getStudentById(int id) throws Exception {
		String sql = "select * from students where student_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Student(rs.getInt("student_id"), rs.getString("student_name"), rs.getString("email"),
						rs.getString("phone"), rs.getInt("age"), rs.getString("city"));
			}
			return null;
		}
	}

	public boolean updateStudent(Student s) throws Exception {
		String sql = "update students set student_name=?, email=?, phone=?, age=?, city=? where student_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPhone());
			ps.setInt(4, s.getAge());
			ps.setString(5, s.getCity());
			ps.setInt(6, s.getId());

			int rows = ps.executeUpdate();
			return rows > 0;
		}
	}

	public boolean hasRegistrations(int studentId) throws Exception {
		String sql = "select count(*) from registrations where student_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt(1) > 0;
			}
			return false;
		}
	}
}