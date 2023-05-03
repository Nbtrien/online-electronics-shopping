package com.shopping.dao;

import com.shopping.model.Image;

public interface IImageDAO extends GenericDAO<Image>{
	int save(Image image);
}
