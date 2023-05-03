package com.shopping.mapper;

import java.sql.ResultSet;

import com.shopping.model.Cart;
import com.shopping.model.User;

public class CartMapper implements RowMapper<Cart>{

	@Override
	public Cart mapRow(ResultSet rs) {
		try {
			Cart cart = new Cart();
			cart.setId(rs.getInt("id"));
			try {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setUserName(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				cart.setUser(user);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return cart;
		} catch (Exception e) {
			return null;
		}
		
	}

}
