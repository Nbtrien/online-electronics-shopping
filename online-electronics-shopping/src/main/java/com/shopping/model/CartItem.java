package com.shopping.model;

public class CartItem extends AbstractModel<CartItem> {
	private Cart cart;
	private Product product;
	private Float price;
	private Float discount;
	private int quantity;
	private int active;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "CartItem [cart=" + cart + ", product=" + product + ", price=" + price + ", discount=" + discount
				+ ", quanity=" + quantity + ", active=" + active + "]";
	}

}
