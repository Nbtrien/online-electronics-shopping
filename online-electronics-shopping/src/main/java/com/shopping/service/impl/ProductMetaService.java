package com.shopping.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.shopping.dao.IProductMetaDAO;
import com.shopping.model.ProductMeta;
import com.shopping.service.IProductMetaService;

public class ProductMetaService implements IProductMetaService{
	
	@Inject
	private IProductMetaDAO productMetaDAO;

	@Override
	public int save(ProductMeta productMeta) {
		// TODO Auto-generated method stub
		return productMetaDAO.save(productMeta);
	}

	@Override
	public List<ProductMeta> findByProductId(int product_id) {
		// TODO Auto-generated method stub
		return productMetaDAO.findByProductId(product_id);
	}

}
