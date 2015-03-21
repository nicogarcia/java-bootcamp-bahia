package com.globant.app.domain.entities.items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globant.app.domain.discounts.DiscountInfo;
import com.globant.app.domain.discounts.IDiscountable;

import javax.persistence.*;

/**
 * This class represents the Item instantiated in an
 * order.
 * It may have a quantity and a price due to a discount.
 */
@MappedSuperclass
public abstract class CartItem implements IDiscountable {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	protected double price;

	private int quantity;

	@Transient
	private DiscountInfo discountInfo;

	protected CartItem() {
	}

	protected CartItem(int quantity) {
		this.quantity = quantity;
	}

	@JsonIgnore
	@Override public boolean hasDiscount() {
		return discountInfo != null;
	}

	@JsonIgnore
	@Override public DiscountInfo getDiscount() {
		return discountInfo;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public DiscountInfo getDiscountInfo() {
		return discountInfo;
	}

	public void setDiscountInfo(DiscountInfo discountInfo) {
		this.discountInfo = discountInfo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
