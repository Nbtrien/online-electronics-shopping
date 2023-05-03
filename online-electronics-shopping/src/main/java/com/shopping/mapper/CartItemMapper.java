package com.shopping.mapper;

import java.sql.ResultSet;

import com.shopping.model.Cart;
import com.shopping.model.CartItem;
import com.shopping.model.Image;
import com.shopping.model.Product;

public class CartItemMapper implements RowMapper<CartItem> {

	@Override
	public CartItem mapRow(ResultSet rs) {
		try {
			CartItem cartItem = new CartItem();
			cartItem.setId(rs.getInt("id"));
			cartItem.setActive(rs.getInt("active"));
			cartItem.setPrice(rs.getFloat("price"));
			cartItem.setQuantity(rs.getInt("quantity"));
			cartItem.setCreatedAt(rs.getTimestamp("created_at"));

			try {
				Product product = new Product();
				product.setId(rs.getInt("product_id"));

				cartItem.setProduct(product);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return cartItem;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
