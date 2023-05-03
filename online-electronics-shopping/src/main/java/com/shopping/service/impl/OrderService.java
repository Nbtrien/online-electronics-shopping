package com.shopping.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.shopping.dao.IOrderDAO;
import com.shopping.dao.IOrderItemDAO;
import com.shopping.model.Order;
import com.shopping.model.OrderItem;
import com.shopping.service.IOrderItemService;
import com.shopping.service.IOrderService;

public class OrderService implements IOrderService {

	@Inject
	private IOrderDAO orderDAO;

	@Inject
	private IOrderItemService iteService;

	@Override
	public int save(Order order) {
		// TODO Auto-generated method stub
		int orderId = orderDAO.save(order);
		order.setId(orderId);
		if (orderId != 0) {
			for (OrderItem item : order.getOrderItems()) {
				item.setOrder(order);
				iteService.save(item);
			}
		}
		return orderId;
	}

	@Override
	public List<Order> findByUserId(int userId) {
		// TODO Auto-generated method stub
		return orderDAO.findByUserId(userId);
	}

}
