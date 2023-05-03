package com.shopping.dao;

import java.util.List;

import com.shopping.model.Brand;

public interface IBrandDAO extends GenericDAO<Brand>{
	List<Brand> findAll();
	int save(Brand brand);
}
