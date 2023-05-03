package com.shopping.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.shopping.dao.IBrandDAO;
import com.shopping.dao.IImageDAO;
import com.shopping.model.Brand;
import com.shopping.model.Image;
import com.shopping.service.IBrandService;

public class BrandService implements IBrandService{
	@Inject
	private IBrandDAO brandDAO;
	
	@Inject
	private IImageDAO imageDAO;

	@Override
	public int save(Brand brand) {
		// TODO Auto-generated method stub
		Image image = brand.getImage();
		int id = imageDAO.save(image);
		image.setId(id);
		brand.setImage(image);
		
		return brandDAO.save(brand);
	}

	@Override
	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return brandDAO.findAll();
	}

}
