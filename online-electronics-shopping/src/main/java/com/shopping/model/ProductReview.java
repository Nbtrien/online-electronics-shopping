package com.shopping.model;

public class ProductReview extends AbstractModel<ProductReview>{
	private Product product;
	private User user;
	private ProductReview reviewParent;
	private int rating;
	private String content;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ProductReview getReviewParent() {
		return reviewParent;
	}
	public void setReviewParent(ProductReview reviewParent) {
		this.reviewParent = reviewParent;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ProductReview [product=" + product + ", user=" + user + ", reviewParent=" + reviewParent + ", rating="
				+ rating + ", content=" + content + "]";
	}
	
	
}
