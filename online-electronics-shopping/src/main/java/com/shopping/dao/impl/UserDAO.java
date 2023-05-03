package com.shopping.dao.impl;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.shopping.dao.IUserDAO;
import com.shopping.mapper.UserMapped;
import com.shopping.model.Category;
import com.shopping.model.User;

public class UserDAO extends AbstractDAO<User> implements IUserDAO{

	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("INSERT INTO users(username, password, email, first_name, last_name,  telephone, address)");
		sql.append(" VALUE(?,?,?,?,?,?,?)");
		return insert(sql.toString(), user.getUserName(), user.getPassWord(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getAddress());
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT *, roles.id as role_id FROM users INNER JOIN roles ON users.role_id = roles.id WHERE users.id = ?";
		List<User> users = query(sql, new UserMapped(), id);
		return users.isEmpty() ? null : users.get(0);
		
	}

	@Override
	public User findByLoginInfor(User user) {
		String sql = "SELECT *, roles.id as role_id FROM users INNER JOIN roles ON users.role_id = roles.id WHERE ( username = ? OR email = ? )";
		List<User> users = query(sql, new UserMapped(), user.getUserName(), user.getUserName());
		for (User user2 : users) {
			if (verifyPassword(user.getPassWord(), user2.getPassWord())) {
				return user2;
			}
		}

		return null;
	}
	
	private boolean verifyPassword(String originalPassword, String storedPassword) {
		return BCrypt.checkpw(originalPassword, storedPassword);
	}

}
