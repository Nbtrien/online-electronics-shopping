package com.shopping.mapper;

import java.sql.ResultSet;

import com.shopping.model.Order;
import com.shopping.model.User;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs) {
		try {
			Order order = new Order();
			order.setId(rs.getInt("id"));
			order.setSubTotal(rs.getFloat("sub_total"));
			order.setAddress(rs.getString("address"));
			order.setFullName(rs.getString("full_name"));
			order.setEmail(rs.getString("email"));
			order.setGrandTotal(rs.getFloat("grand_total"));
			order.setMobile(rs.getString("mobile"));
			order.setStatus(rs.getInt("status"));
			order.setCreatedAt(rs.getTimestamp("created_at"));

			User user = new User();
			user.setId(rs.getInt("user_id"));
			order.setUser(user);

			return order;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
