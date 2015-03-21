package com.globant.app.domain.entities.items;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CartProduct extends CartItem implements Comparable<CartProduct> {

	@OneToOne
	private Product product;

	public CartProduct() {
	}

	public CartProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return hasDiscount() ? getDiscount().getDiscountFunction().calculateDiscount(product.getPrice()) : product.getPrice();
	}

	@Override public int compareTo(CartProduct cartProduct) {
		return product.compareTo(cartProduct.getProduct());
	}
}
