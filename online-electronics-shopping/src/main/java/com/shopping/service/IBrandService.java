package com.shopping.service;

import java.util.List;

import com.shopping.model.Brand;

public interface IBrandService {
	int save(Brand brand);
	List<Brand> findAll();
}
