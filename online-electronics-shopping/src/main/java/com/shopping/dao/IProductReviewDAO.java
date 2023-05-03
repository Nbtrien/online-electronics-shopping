package com.shopping.dao;

import java.util.List;

import com.shopping.model.ProductReview;

public interface IProductReviewDAO extends GenericDAO<ProductReview>{
	int save(ProductReview productReview);
	List<ProductReview> findByProductId(int productId);
}
