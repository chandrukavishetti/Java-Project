package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.studentcourse.model.Admin;
import com.studentcourse.util.DBConnection;

public class AdminDAO {

	public boolean adminLogin(Admin admin) throws Exception {

		String sql = "select * from admin where username=? and password=?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());

			ResultSet rs = ps.executeQuery();

			return rs.next();
		}
	}
}