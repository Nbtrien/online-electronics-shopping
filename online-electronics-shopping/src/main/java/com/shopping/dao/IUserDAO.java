package com.shopping.dao;

import com.shopping.model.Category;
import com.shopping.model.User;

public interface IUserDAO extends GenericDAO<User>{
	int save (User user);
	User findById(int id);
	User findByLoginInfor(User user);
}
