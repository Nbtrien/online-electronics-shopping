package com.shopping.dao;

import java.util.List;

import com.shopping.model.Category;
import com.shopping.paging.Pageble;

public interface ICategoryDAO extends GenericDAO<Category>{
	List<Category> findAll();
	List<Category> findAll(Pageble pageble);
	List<Category> findByProductOwner(Pageble pageble);
	Category update (Category category);
	int save (Category category);
	Category findOne(int id);
	void delete(int id);
}
