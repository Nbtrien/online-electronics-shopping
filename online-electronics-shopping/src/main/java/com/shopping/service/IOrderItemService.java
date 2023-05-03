package com.shopping.service;

import java.util.List;

import com.shopping.model.OrderItem;

public interface IOrderItemService {
	int save(OrderItem item);
	List<OrderItem> findByOrderId(int orderId);
}
