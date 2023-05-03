package com.shopping.dao;

import java.util.List;

import com.shopping.model.Order;
import com.shopping.model.OrderItem;

public interface IOrderItemDAO extends GenericDAO<OrderItem> {
	int save(OrderItem item);
	List<OrderItem> findByOrderId(int orderId);
}
