package com.shopping.dao.impl;

import java.util.List;

import com.shopping.dao.ICartDAO;
import com.shopping.mapper.CartMapper;
import com.shopping.mapper.CategoryMapper;
import com.shopping.model.Cart;
import com.shopping.model.Category;

public class CartDAO extends AbstractDAO<Cart> implements ICartDAO{

	@Override
	public Cart findByUserId(int userId) {
		String sql = "SELECT * FROM carts WHERE user_id = ?";
		List<Cart> carts = query(sql, new CartMapper(), userId);
		return carts.isEmpty() ? null : carts.get(0);
	}

}
