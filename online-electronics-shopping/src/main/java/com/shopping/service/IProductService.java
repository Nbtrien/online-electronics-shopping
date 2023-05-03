package com.shopping.service;

import java.util.List;

import com.shopping.model.Product;
import com.shopping.paging.Pageble;

public interface IProductService {
	int save(Product product);
	List<Product> findAll();
	List<Product> findByCategoryId(int category_id, Pageble pageble);
	Product findById(int id);
	List<Product> findRelated(Product product, Pageble pageble);
}
