package com.shopping.dao.impl;

import java.util.List;

import com.shopping.dao.IProductMetaDAO;
import com.shopping.mapper.ProductMetaMapper;
import com.shopping.model.ProductMeta;

public class ProductMetaDAO extends AbstractDAO<ProductMeta> implements IProductMetaDAO{

	@Override
	public int save(ProductMeta productMeta) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO product_metas(product_id, `key`, content) VALUES (?,?,?)";
		return insert(sql, productMeta.getProduct().getId(), productMeta.getKey(), productMeta.getContent());
	}

	@Override
	public List<ProductMeta> findByProductId(int product_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM product_metas WHERE product_id = ?";
		return query(sql, new ProductMetaMapper(), product_id);
	}

}
