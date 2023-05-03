package com.shopping.dao;

import com.shopping.model.Cart;

public interface ICartDAO extends GenericDAO<Cart>{
	Cart findByUserId(int userId);
	
}
