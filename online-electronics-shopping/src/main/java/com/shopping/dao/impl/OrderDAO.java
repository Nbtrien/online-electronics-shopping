package com.shopping.dao.impl;

import java.util.List;

import com.shopping.dao.IOrderDAO;
import com.shopping.mapper.OrderMapper;
import com.shopping.model.Order;

public class OrderDAO extends AbstractDAO<Order> implements IOrderDAO{

	@Override
	public int save(Order order) {
		String sql = "INSERT INTO orders(user_id, sub_total, grand_total, full_name, mobile, email, address) VALUES(?,?,?,?,?,?,?)";
		return insert(sql, order.getUser().getId(), order.getSubTotal().toString(), order.getGrandTotal().toString(), order.getFullName(), order.getMobile(), order.getEmail(), order.getAddress());
	}

	@Override
	public List<Order> findByUserId(int userId) {
		String sql = "SELECT * FROM orders WHERE user_id = ?";
		return query(sql, new OrderMapper(), userId);
	}

}
