package com.globant.app.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.globant.app.domain.entities.carts.Cart;
import com.globant.app.domain.entities.carts.OrderCart;
import com.globant.app.domain.paymentMethods.IPaymentMethod;
import com.globant.app.domain.utilities.PaymentMethodInjector;

import javax.persistence.*;

@Entity
@Table(name = "order_table")
@Access(AccessType.FIELD)
public class Order {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private OrderCart orderCart;

	@Transient
	private Cart cart;

	@ManyToOne
	@JsonIgnore
	private Customer customer;

	private String paymentType;

	@Transient
	private IPaymentMethod paymentMethod;

	private boolean paid;

	public Order() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty
	public OrderCart getOrderCart() {
		return orderCart;
	}

	@JsonIgnore
	public void setOrderCart(OrderCart orderCart) {
		this.orderCart = orderCart;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@JsonProperty
	public IPaymentMethod getPaymentMethod() {
		return PaymentMethodInjector.getPaymentMethod(paymentType);
	}

	@JsonIgnore
	public void setPaymentMethod(IPaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@JsonIgnore
	public Cart getCart() {
		return cart;
	}

	@JsonProperty
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@JsonProperty
	public boolean isPaid() {
		return paid;
	}

	@JsonIgnore
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
}
