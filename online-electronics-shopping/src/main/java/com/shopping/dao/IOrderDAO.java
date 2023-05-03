package com.shopping.dao;

import java.util.List;

import com.shopping.model.Order;

public interface IOrderDAO extends GenericDAO<Order>{
	int save(Order order);
	List<Order> findByUserId(int userId);
}
