package com.shopping.model;

import java.util.Arrays;
import java.util.List;

public class Category {
	private int id;
	private String name;
	private int[] ids;
	private Image image;
	private Image iconImage;
	private List<Product> products;
	
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	
	
	public Image getIconImage() {
		return iconImage;
	}
	public void setIconImage(Image iconImage) {
		this.iconImage = iconImage;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", ids=" + Arrays.toString(ids) + ", image=" + image
				+ ", iconImage=" + iconImage + ", products=" + products + "]";
	}
	
	
}
