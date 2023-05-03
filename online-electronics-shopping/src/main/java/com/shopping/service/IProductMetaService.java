package com.shopping.service;

import java.util.List;

import com.shopping.model.ProductMeta;

public interface IProductMetaService {
	int save(ProductMeta productMeta);
	List<ProductMeta> findByProductId(int product_id);
}
