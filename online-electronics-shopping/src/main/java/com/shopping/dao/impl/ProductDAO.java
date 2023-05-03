package com.shopping.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.shopping.dao.IProductDAO;
import com.shopping.mapper.ProductMapper;
import com.shopping.model.Product;
import com.shopping.paging.Pageble;

public class ProductDAO extends AbstractDAO<Product> implements IProductDAO{

	@Override
	public int save(Product product) {
		String sql = "INSERT INTO products(name, display_name, description, price, quantity, warranty, category_id, brand_id, image_id) VALUES(?,?,?,?,?,?,?,?,?)";
		
		// TODO Auto-generated method stub
		System.out.println(product.getWarranty());
		return insert(sql, product.getName(), product.getDisplayName(), product.getDescription(), product.getPrice().toString(), product.getQuantity(), product.getWarranty().toString(), product.getCategory().getId(), product.getBrand().getId(), product.getImage().getId());
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
//		String sql = "SELECT * FROM products";
		StringBuilder sql = new StringBuilder("SELECT products.id as id, products.name as name, products.display_name as display_name, description, price, quantity, warranty, category_id, brand_id");
		sql.append(", products.image_id as image_id, categories.name as category_name, brands.name as brand_name, images.image_url as image_url");
		sql.append(" FROM (products INNER JOIN categories ON products.category_id = categories.id");
		sql.append(" INNER JOIN brands ON products.brand_id = brands.id");
		sql.append(" INNER JOIN images ON products.image_id = images.id)");
		
		return query(sql.toString(), new ProductMapper());
	}

	@Override
	public List<Product> findByCategoryId(int category_id, Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT products.id as id, products.name as name, products.display_name as display_name, description, price, quantity, warranty, category_id, brand_id");
		sql.append(", products.image_id as image_id, categories.name as category_name, brands.name as brand_name, images.image_url as image_url");
		sql.append(" FROM (products INNER JOIN categories ON products.category_id = categories.id");
		sql.append(" INNER JOIN brands ON products.brand_id = brands.id");
		sql.append(" INNER JOIN images ON products.image_id = images.id)");
		sql.append(" WHERE category_id = ?");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"");
		}
		
		return query(sql.toString(), new ProductMapper(), category_id);
	}

	@Override
	public Product findById(int id) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("SELECT products.id as id, products.name as name, products.display_name as display_name, description, price, quantity, warranty, category_id, brand_id");
		sql.append(", products.image_id as image_id, categories.name as category_name, brands.name as brand_name, images.image_url as image_url");
		sql.append(" FROM (products INNER JOIN categories ON products.category_id = categories.id");
		sql.append(" INNER JOIN brands ON products.brand_id = brands.id");
		sql.append(" INNER JOIN images ON products.image_id = images.id)");
		sql.append(" WHERE products.id = ?");
		List<Product> products = query(sql.toString(), new ProductMapper(), id);
		return products.isEmpty() ? null : products.get(0);
	}

	@Override
	public List<Product> findRelatedProduct(Product product, Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT products.id as id, products.name as name, products.display_name as display_name, description, price, quantity, warranty, category_id, brand_id");
		sql.append(", products.image_id as image_id, images.image_url as image_url");
		sql.append(" FROM products INNER JOIN images ON products.image_id = images.id");
		sql.append(" WHERE category_id = ? AND brand_id = ? AND products.id not in (select id from products where id = ?)");
		
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"");
		}
		
		return query(sql.toString(), new ProductMapper(), product.getCategory().getId(), product.getBrand().getId(), product.getId());
	}

}
