package com.shopping.dao.impl;

import java.util.List;

import com.shopping.dao.IOrderItemDAO;
import com.shopping.mapper.OrderItemMapper;
import com.shopping.model.Order;
import com.shopping.model.OrderItem;

public class OrderItemDAO extends AbstractDAO<OrderItem> implements IOrderItemDAO {

	@Override
	public int save(OrderItem item) {
		String sql = "INSERT INTO order_items(product_id, order_id, price, quantity) VALUES (?,?,?,?)";
		return insert(sql, item.getProduct().getId(), item.getOrder().getId(), item.getPrice().toString(), item.getQuantity());
	}

	@Override
	public List<OrderItem> findByOrderId(int orderId) {
		String sql = "SELECT * FROM order_items WHERE order_id = ?";
		return query(sql, new OrderItemMapper(), orderId);
	}

}
