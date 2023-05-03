package com.shopping.service;

import com.shopping.model.Cart;

public interface ICartService {
	Cart findByUserId(int userId);
}
