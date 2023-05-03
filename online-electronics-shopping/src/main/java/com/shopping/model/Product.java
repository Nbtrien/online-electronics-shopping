package com.shopping.model;

import java.sql.Date;
import java.util.List;

public class Product extends AbstractModel<Product> {
	private String name;
	private String displayName;
	private String description;
	private Float price;
	private int quantity;
	private Date warranty;
	private String address;
	private Category category;
	private Image image;
	private Brand brand;
	private List<ProductMeta> productMetas;
	private List<ProductReview> reviews;
	private Float rating;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getWarranty() {
		return warranty;
	}

	public void setWarranty(Date warranty) {
		this.warranty = warranty;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<ProductMeta> getProductMetas() {
		return productMetas;
	}

	public void setProductMetas(List<ProductMeta> productMetas) {
		this.productMetas = productMetas;
	}

	public List<ProductReview> getReviews() {
		return reviews;
	}

	public void setReviews(List<ProductReview> reviews) {
		this.reviews = reviews;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", displayName=" + displayName + ", description=" + description + ", price="
				+ price + ", quantity=" + quantity + ", warranty=" + warranty + ", address=" + address + ", category="
				+ category + ", image=" + image + ", brand=" + brand + "]";
	}

}
