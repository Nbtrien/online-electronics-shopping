package com.shopping.service.impl;

import javax.inject.Inject;

import com.shopping.dao.ICartDAO;
import com.shopping.model.Cart;
import com.shopping.service.ICartService;

public class CartService implements ICartService{

	@Inject 
	private ICartDAO cartDAO;
	
	@Override
	public Cart findByUserId(int userId) {
		// TODO Auto-generated method stub
		return cartDAO.findByUserId(userId);
	}

}
