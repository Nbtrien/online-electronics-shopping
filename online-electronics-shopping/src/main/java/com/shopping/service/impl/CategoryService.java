package com.shopping.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.shopping.dao.ICategoryDAO;
import com.shopping.dao.IImageDAO;
import com.shopping.model.Category;
import com.shopping.model.Image;
import com.shopping.paging.Pageble;
import com.shopping.service.ICategoryService;

public class CategoryService implements ICategoryService{
	
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Inject
	private IImageDAO imageDAO;

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDAO.findAll();
	}

	@Override
	public int save(Category category) {
		// TODO Auto-generated method stub
		Image image = category.getImage();
		
		int imgId = imageDAO.save(image);
		image.setId(imgId);
		category.setImage(image);
		
		return categoryDAO.save(category);
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return categoryDAO.update(category);
	}

	@Override
	public void delete(int[] ids) {
		// TODO Auto-generated method stub
		for (int id : ids) {
			categoryDAO.delete(id);
		}
	}

	@Override
	public List<Category> findByProductOwner(Pageble pageble) {
		// TODO Auto-generated method stub
		return categoryDAO.findByProductOwner(pageble);
	}

	@Override
	public List<Category> findAll(Pageble pageble) {
		// TODO Auto-generated method stub
		return categoryDAO.findAll(pageble);
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return categoryDAO.findOne(id);
	}

}
