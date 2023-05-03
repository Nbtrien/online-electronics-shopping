package com.shopping.model;

import java.util.Arrays;

public class Brand extends AbstractModel<Brand>{
	private int id;
	private String name;
	private int[] ids;
	private Image image;
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
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", ids=" + Arrays.toString(ids) + ", image=" + image + "]";
	}
	
	
}
