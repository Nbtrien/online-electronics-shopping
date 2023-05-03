package com.shopping.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.model.Role;
import com.shopping.model.User;

public class UserMapped implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		User user = new User();
		try {
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("username"));
			user.setPassWord(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			try {
				Role role = new Role();
				role.setId(rs.getInt("role_id"));
				role.setName(rs.getString("name"));
				user.setRole(role);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
