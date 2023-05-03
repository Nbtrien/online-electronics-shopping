package com.shopping.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.model.ProductReview;
import com.shopping.model.User;

public class ProductReviewMapper implements RowMapper<ProductReview>{

	@Override
	public ProductReview mapRow(ResultSet rs) {
		try {
			ProductReview review = new ProductReview();
			review.setId(rs.getInt("id"));
			review.setRating(rs.getInt("rating"));
			review.setContent(rs.getString("content"));
			review.setCreatedAt(rs.getTimestamp("create_at"));
			try {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setUserName(rs.getString("name"));
				review.setUser(user);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return review;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
