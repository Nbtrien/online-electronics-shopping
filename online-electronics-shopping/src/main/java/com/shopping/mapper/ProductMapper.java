package com.shopping.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.model.Brand;
import com.shopping.model.Category;
import com.shopping.model.Image;
import com.shopping.model.Product;

public class ProductMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs) {
		// TODO Auto-generated method stub
		
		try {
			Product product = new Product();
			product.setId(rs.getInt("id"));
			product.setName(rs.getString("name"));
			product.setDisplayName(rs.getString("display_name"));
			product.setPrice(rs.getFloat("price"));
			product.setQuantity(rs.getInt("quantity"));
			product.setDescription(rs.getString("description"));
			product.setWarranty(rs.getDate("warranty"));
			
			try {
				Image image = new Image();
				image.setId(rs.getInt("image_id"));
				image.setImageUrl(rs.getString("image_url"));
				product.setImage(image);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Category category = new Category();
				category.setId(rs.getInt("category_id"));
				category.setName(rs.getString("category_name"));
				product.setCategory(category);
			} catch (Exception e) {
//				e.printStackTrace();
			}
			try {
				Brand brand = new Brand();
				brand.setId(rs.getInt("brand_id"));
				brand.setName(rs.getString("brand_name"));
				product.setBrand(brand);
			} catch (Exception e) {
//				e.printStackTrace();
			}
			return product;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

}
