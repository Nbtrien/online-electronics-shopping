package com.shopping.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.shopping.dao.IProductReviewDAO;
import com.shopping.model.ProductReview;
import com.shopping.service.IProductReviewService;

public class ProductReviewService implements IProductReviewService{
	
	@Inject
	private IProductReviewDAO productReviewDAO;
	
	@Override
	public int save(ProductReview productReview) {
		// TODO Auto-generated method stub
		return productReviewDAO.save(productReview);
	}

	@Override
	public List<ProductReview> findByProductId(int productId) {
		// TODO Auto-generated method stub
		return productReviewDAO.findByProductId(productId);
	}

}
