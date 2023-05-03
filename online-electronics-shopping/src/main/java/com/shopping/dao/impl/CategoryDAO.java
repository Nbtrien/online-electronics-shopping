package com.shopping.dao.impl;

import java.awt.print.Pageable;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.shopping.dao.ICategoryDAO;
import com.shopping.mapper.CategoryMapper;
import com.shopping.model.Category;
import com.shopping.paging.Pageble;

public class CategoryDAO extends AbstractDAO<Category> implements ICategoryDAO {

	@Override
	public List<Category> findAll() {
		String sql = "SELECT categories.id as id, name, image_id, images.image_url as image_url  FROM categories INNER JOIN images ON categories.image_id = images.id";
		return query(sql, new CategoryMapper());
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		String sql = "UPDATE categories SET name = ? where id = ?";
		update(sql, category.getName(), category.getId());

		return findOne(category.getId());
	}

	@Override
	public int save(Category category) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO categories(name, image_id) VALUES (?,?)";
		return insert(sql, category.getName(), category.getImage().getId());
	}

	@Override
	public Category findOne(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM categories where id = ?";
		List<Category> categories = query(sql, new CategoryMapper(), id);
		return categories.isEmpty() ? null : categories.get(0);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM categories WHERE id = ?";
		update(sql, id);
	}

	@Override
	public List<Category> findByProductOwner(Pageble pageble) {
		StringBuilder sql = new StringBuilder(
				"SELECT * FROM categories INNER JOIN products ON products.category_id = categories.id GROUP BY categories.name");

		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
		}
		return query(sql.toString(), new CategoryMapper());
	}

	@Override
	public List<Category> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT cat.id as id, name, image_id, icon_img_id, img.image_url as image_url, ic.image_url as icon_url FROM categories as cat");
		sql.append(" LEFT JOIN images img ON cat.image_id = img.id");
		sql.append(" LEFT JOIN images ic ON cat.icon_img_id = ic.id");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())
				&& StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
		}
		return query(sql.toString(), new CategoryMapper());
	}

}
