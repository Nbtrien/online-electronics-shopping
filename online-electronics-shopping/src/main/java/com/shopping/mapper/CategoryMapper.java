package com.shopping.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.model.Category;
import com.shopping.model.Image;

public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs) {
		try {
			Category category = new Category();
			category.setId(rs.getInt("id"));
			category.setName(rs.getString("name"));
			try {
				Image image = new Image();
				image.setId(rs.getInt("image_id"));
				image.setImageUrl(rs.getString("image_url"));
				category.setImage(image);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Image image = new Image();
				image.setId(rs.getInt("icon_img_id"));
				image.setImageUrl(rs.getString("icon_url"));
				category.setIconImage(image);
			} catch (Exception e) {
			}
			return category;
		} catch (SQLException e) {
			return null;
		}
	}

}
