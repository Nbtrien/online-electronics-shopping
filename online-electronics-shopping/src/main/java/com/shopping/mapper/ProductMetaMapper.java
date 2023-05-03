package com.shopping.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.model.ProductMeta;

public class ProductMetaMapper implements RowMapper<ProductMeta>{

	@Override
	public ProductMeta mapRow(ResultSet rs) {
		try {
			ProductMeta productMeta = new ProductMeta();
			productMeta.setId(rs.getInt("id"));
			productMeta.setKey(rs.getString("key"));
			productMeta.setContent(rs.getString("content"));
			return productMeta;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
