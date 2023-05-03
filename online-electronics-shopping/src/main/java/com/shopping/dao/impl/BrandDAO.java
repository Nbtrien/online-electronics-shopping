package com.shopping.dao.impl;

import java.util.List;

import com.shopping.dao.IBrandDAO;
import com.shopping.mapper.BrandMapper;
import com.shopping.model.Brand;

public class BrandDAO extends AbstractDAO<Brand> implements IBrandDAO{

	@Override
	public int save(Brand brand) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO brands(name, image_id) VALUES(?,?)";
		
		return insert(sql, brand.getName(), brand.getImage().getId());
	}

	@Override
	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM brands";
		List<Brand> brands = query(sql, new BrandMapper());
		return brands;
	}

}
