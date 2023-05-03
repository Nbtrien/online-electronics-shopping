package com.shopping.dao;

import java.util.List;

import com.shopping.model.CartItem;

public interface ICartItemDAO extends GenericDAO<CartItem>{
	int save(CartItem cartItem);
	List<CartItem> findByCartId(int cartId);
	int countByCartId(int cartId);
}
