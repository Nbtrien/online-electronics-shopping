package com.shopping.dao.impl;

import java.util.List;

import com.shopping.dao.ICartItemDAO;
import com.shopping.mapper.CartItemMapper;
import com.shopping.model.CartItem;

public class CartItemDAO extends AbstractDAO<CartItem> implements ICartItemDAO {

	@Override
	public int save(CartItem cartItem) {
		String sql = "INSERT INTO cart_items(product_id, cart_id, price, quantity) VALUES(?,?,?,?)";
		return insert(sql, cartItem.getProduct().getId(), cartItem.getCart().getId(), cartItem.getPrice().toString(),
				cartItem.getQuantity());
	}

	@Override
	public List<CartItem> findByCartId(int cartId) {
//		StringBuilder sql = new StringBuilder(
//				"SELECT item.id as id, active, item.price as price, item.quantity as quantity, item.created_at as created_at,");
//		sql.append(
//				" pd.id as product_id, name, display_name,  pd.price as product_price, pd.quantity as product_quanity, warranty,");
//		sql.append(
//				" img.id as image_id, image_url");
//		sql.append(" FROM cart_items as item");
//		sql.append(" INNER JOIN products as pd ON item.product_id = pd.id");
//		sql.append(" INNER JOIN images as img ON pd.image_id = img.id");
//		sql.append(" WHERE cart_id = ?");

		StringBuilder sql = new StringBuilder(
				"SELECT item.id as id, active, item.price as price, item.quantity as quantity, item.created_at as created_at,");
		sql.append(" pd.id as product_id");
		sql.append(" FROM cart_items as item");
		sql.append(" INNER JOIN products as pd ON item.product_id = pd.id");
		sql.append(" WHERE cart_id = ?");
		return query(sql.toString(), new CartItemMapper(), cartId);
	}

	@Override
	public int countByCartId(int cartId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
