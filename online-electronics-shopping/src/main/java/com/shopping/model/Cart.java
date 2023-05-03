package com.shopping.model;

import java.util.List;

public class Cart extends AbstractModel<Cart>{
	private User user;
	private int status;
	private List<CartItem> cartItems;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	@Override
	public String toString() {
		return "Cart [user=" + user + ", status=" + status + ", cartItems=" + cartItems + "]";
	}
	
	
	
}
