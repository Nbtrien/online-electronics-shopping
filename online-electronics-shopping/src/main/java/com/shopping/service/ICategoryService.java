package com.shopping.service;

import java.util.List;

import com.shopping.model.Category;
import com.shopping.paging.Pageble;

public interface ICategoryService {
	List<Category> findAll();
	List<Category> findAll(Pageble pageble);
	List<Category> findByProductOwner(Pageble pageble);
	int save(Category category);
	Category update(Category category);
	Category findById(int id);
	void delete(int[] ids);
}
