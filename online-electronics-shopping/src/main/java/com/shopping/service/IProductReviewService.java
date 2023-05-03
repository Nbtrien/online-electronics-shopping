package com.shopping.service;

import java.util.List;

import com.shopping.model.ProductReview;

public interface IProductReviewService {
	int save(ProductReview productReview);

	List<ProductReview> findByProductId(int productId);
}
