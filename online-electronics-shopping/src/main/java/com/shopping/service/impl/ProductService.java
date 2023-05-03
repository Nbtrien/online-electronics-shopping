package com.shopping.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.shopping.dao.IImageDAO;
import com.shopping.dao.IProductDAO;
import com.shopping.dao.impl.ImageDAO;
import com.shopping.model.Image;
import com.shopping.model.Product;
import com.shopping.paging.Pageble;
import com.shopping.service.IProductService;

public class ProductService implements IProductService{
	
	@Inject
	private IImageDAO imageDAO;
	
	@Inject
	private  IProductDAO productDAO;

	@Override
	public int save(Product product) {
		// TODO Auto-generated method stub
		Image image = product.getImage();
		
		int imgId = imageDAO.save(image);
		image.setId(imgId);
		product.setImage(image);
		
		return productDAO.save(product);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDAO.findAll();
	}

	@Override
	public List<Product> findByCategoryId(int category_id, Pageble pageble) {
		// TODO Auto-generated method stub
		return productDAO.findByCategoryId(category_id, pageble);
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		return productDAO.findById(id);
	}

	@Override
	public List<Product> findRelated(Product product, Pageble pageble) {
		// TODO Auto-generated method stub
		return productDAO.findRelatedProduct(product, pageble);
	}

}
