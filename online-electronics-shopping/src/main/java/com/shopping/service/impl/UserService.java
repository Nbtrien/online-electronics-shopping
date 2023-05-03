package com.shopping.service.impl;

import javax.inject.Inject;

import com.shopping.dao.impl.UserDAO;
import com.shopping.model.User;
import com.shopping.service.IUserService;

public class UserService implements IUserService{
	@Inject
	private UserDAO userDAO;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		int id = userDAO.save(user);
		return userDAO.findById(id);
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}

	@Override
	public User findByLoginInfor(User user) {
		// TODO Auto-generated method stub
		return userDAO.findByLoginInfor(user);
	}
	
	

}
