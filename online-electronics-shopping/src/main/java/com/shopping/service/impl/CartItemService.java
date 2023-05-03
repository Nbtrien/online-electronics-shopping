package com.shopping.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.shopping.dao.ICartDAO;
import com.shopping.dao.ICartItemDAO;
import com.shopping.dao.IProductDAO;
import com.shopping.model.Cart;
import com.shopping.model.CartItem;
import com.shopping.model.Product;
import com.shopping.service.ICartItemService;

public class CartItemService implements ICartItemService {

	@Inject
	private ICartDAO cartDAO;
	@Inject
	private ICartItemDAO cartItemDAO;
	@Inject
	private IProductDAO productDAO;

	@Override
	public int save(CartItem cartItem, int userId) {
		Cart cart = cartDAO.findByUserId(userId);
		cartItem.setCart(cart);
		return cartItemDAO.save(cartItem);
	}

	@Override
	public List<CartItem> findByCartId(int cartId) {
		// TODO Auto-generated method stub
		List<CartItem> cartItems = cartItemDAO.findByCartId(cartId);
		for (CartItem cartItem : cartItems) {
			Product product = productDAO.findById(cartItem.getProduct().getId());
			cartItem.setProduct(product);
		}

		return cartItems;
	}

	@Override
	public int countByCartId(int cartId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
