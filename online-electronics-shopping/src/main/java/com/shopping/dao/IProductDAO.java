package com.shopping.dao;

import java.util.List;

import com.shopping.model.Product;
import com.shopping.paging.Pageble;

public interface IProductDAO extends GenericDAO<Product>{
	int save(Product product);
	List<Product> findAll();
	List<Product> findByCategoryId(int category_id,Pageble pageble);
	List<Product> findRelatedProduct(Product product,Pageble pageble);
	Product findById(int id);
}
