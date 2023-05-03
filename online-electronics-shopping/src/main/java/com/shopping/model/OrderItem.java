package com.shopping.model;

public class OrderItem extends AbstractModel<OrderItem>{
	private Product product;
	private Order order;
	private Float price;
	private int quantity;
	private Float discount;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
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
	public Float getDiscount() {
		return discount;
	}
	public void setDiscount(Float discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "OrderItem [product=" + product + ", order=" + order + ", price=" + price + ", quantity=" + quantity
				+ ", discount=" + discount + "]";
	}
	
	
}
