package com.shopping.dao;

import java.util.List;

import com.shopping.model.ProductMeta;

public interface IProductMetaDAO extends GenericDAO<ProductMeta>{
	int save(ProductMeta productMeta);
	List<ProductMeta> findByProductId(int product_id);
}
