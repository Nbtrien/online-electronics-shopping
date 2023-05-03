package com.shopping.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.shopping.dao.IOrderItemDAO;
import com.shopping.model.OrderItem;
import com.shopping.model.Product;
import com.shopping.service.IOrderItemService;
import com.shopping.service.IProductService;

public class OrderItemService implements IOrderItemService {

	@Inject
	private IOrderItemDAO itemDAO;
	@Inject
	private IProductService productService;

	@Override
	public int save(OrderItem item) {
		// TODO Auto-generated method stub
		return itemDAO.save(item);
	}

	@Override
	public List<OrderItem> findByOrderId(int orderId) {
		List<OrderItem> orderItems = itemDAO.findByOrderId(orderId);
		for (OrderItem orderItem : orderItems) {
			Product product = productService.findById(orderItem.getProduct().getId());
			orderItem.setProduct(product);
		}
		return orderItems;
	}

}
