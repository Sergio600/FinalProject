package com.sergio.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Class that represents POJO of order.
 */
@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (unique = true, nullable = false)
	private Integer id;

	@Column(name = "TOTAL_PRICE")
	private double totalPrice;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ORDER_GOOD",
	joinColumns = @JoinColumn(name = "ORDER_ID"),
	inverseJoinColumns = @JoinColumn(name = "GOOD_ID", unique = false))
	private List<Product> products;

	@ManyToOne(optional=false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

	public Order(){}

	public Order(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
