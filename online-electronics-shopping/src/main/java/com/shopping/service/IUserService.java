package com.shopping.service;

import com.shopping.model.User;

public interface IUserService {
	User save(User user);
	User findById(int id);
	User findByLoginInfor(User user);
}
