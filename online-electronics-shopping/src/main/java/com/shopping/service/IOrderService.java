package com.shopping.service;

import java.util.List;

import com.shopping.model.Order;

public interface IOrderService {
	int save(Order order);
	List<Order> findByUserId(int userId);
}
