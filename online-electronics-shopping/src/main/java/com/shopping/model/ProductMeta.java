package com.shopping.model;

public class ProductMeta extends AbstractModel<ProductMeta> {
	private String key;
	private String content;
	private Product product;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductMeta [key=" + key + ", content=" + content + ", product=" + product + "]";
	}

}
