package com.shopping.mapper;

import java.sql.ResultSet;

import com.shopping.model.OrderItem;
import com.shopping.model.Product;

public class OrderItemMapper implements RowMapper<OrderItem>{

	@Override
	public OrderItem mapRow(ResultSet rs) {
		try {
			OrderItem item = new OrderItem();
			item.setId(rs.getInt("id"));
			
			item.setPrice(rs.getFloat("price"));
			item.setQuantity(rs.getInt("quantity"));
			item.setCreatedAt(rs.getTimestamp("created_at"));
			
			Product pd = new Product();
			pd.setId(rs.getInt("product_id"));
			
			item.setProduct(pd);
			return item;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		}
		
	}

}
