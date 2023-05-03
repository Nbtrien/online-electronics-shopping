package com.shopping.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.model.Brand;
import com.shopping.model.Category;

public class BrandMapper implements RowMapper<Brand>{

	@Override
	public Brand mapRow(ResultSet rs) {
		try {
			Brand brand = new Brand();
			brand.setId(rs.getInt("id"));
			brand.setName(rs.getString("name"));
			return brand;
		} catch (SQLException e) {
			return null;
		}
	}

}
