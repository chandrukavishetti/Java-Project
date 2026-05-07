package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.studentcourse.model.Student;
import com.studentcourse.util.DBConnection;

public class StudentDAO {

	public boolean addStudent(Student s) throws Exception {

		String sql = "insert into students(student_name,email,phone,age,city) values(?,?,?,?,?)";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPhone());
			ps.setInt(4, s.getAge());
			ps.setString(5, s.getCity());

			int rows = ps.executeUpdate();

			return rows > 0;
		}
	}
}