package com.shopping.dao.impl;

import java.util.List;

import com.shopping.dao.IProductReviewDAO;
import com.shopping.mapper.ProductReviewMapper;
import com.shopping.model.ProductReview;

public class ProductReviewDAO extends AbstractDAO<ProductReview> implements IProductReviewDAO{

	@Override
	public int save(ProductReview productReview) {
		String sql = "INSERT INTO product_reviews(product_id, user_id, rating, content) VALUES (?,?,?,?)";
		return insert(sql, productReview.getProduct().getId(), productReview.getUser().getId(), productReview.getRating(), productReview.getContent());
	}

	@Override
	public List<ProductReview> findByProductId(int productId) {
		StringBuilder sql = new StringBuilder("SELECT rv.id as id, rating, content, create_at, product_id, user_id, us.username as name");
		sql.append(" FROM product_reviews as rv INNER JOIN users as us ON rv.user_id = us.id  WHERE product_id=? ORDER BY create_at DESC");
		return query(sql.toString(), new ProductReviewMapper(), productId);
	}

}
