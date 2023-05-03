package com.shopping.service;

import java.util.List;

import com.shopping.model.CartItem;

public interface ICartItemService {
	int save(CartItem cartItem, int userId);
	List<CartItem> findByCartId(int cartId);
	int countByCartId(int cartId);
}
