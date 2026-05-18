package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.studentcourse.model.Course;
import com.studentcourse.util.DBConnection;

public class CourseDAO {
	public boolean addCourse(Course c) throws Exception {
		String sql = "insert into courses(course_name,duration,fees,trainer_name) values (?,?,?,?)";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(sql)) {

			preparedstatement.setString(1, c.getName());
			preparedstatement.setInt(2, c.getDuration());
			preparedstatement.setFloat(3, c.getFees());
			preparedstatement.setString(4, c.getTrainer());

			int rows = preparedstatement.executeUpdate();

			return rows > 0;

		}
	}

	public List<Course> getAllCourses() throws Exception {
		String sql = "select * from courses";
		List<Course> courses = new ArrayList<>();

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Course c = new Course(rs.getInt("course_id"), rs.getString("course_name"), rs.getInt("duration"),
						rs.getFloat("fees"), rs.getString("trainer_name"));
				courses.add(c);
			}
		}
		return courses;
	}

	public Course getCourseById(int id) throws Exception {
		String sql = "select * from courses where course_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Course(rs.getInt("course_id"), rs.getString("course_name"), rs.getInt("duration"),
						rs.getFloat("fees"), rs.getString("trainer_name"));
			}
			return null;
		}
	}

	public boolean updateCourse(Course c) throws Exception {
		String sql = "update courses set course_name=?, duration=?, fees=?, trainer_name=? where course_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setString(1, c.getName());
			ps.setInt(2, c.getDuration());
			ps.setFloat(3, c.getFees());
			ps.setString(4, c.getTrainer());
			ps.setInt(5, c.getId());

			int rows = ps.executeUpdate();
			return rows > 0;
		}
	}

	public boolean deleteCourse(int id) throws Exception {
		String sql = "delete from courses where course_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			return rows > 0;
		}
	}

	public boolean hasRegistrations(int courseId) throws Exception {
		String sql = "select count(*) from registrations where course_id=?";

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)) {

			ps.setInt(1, courseId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getInt(1) > 0;
			}
			return false;
		}
	}

}
