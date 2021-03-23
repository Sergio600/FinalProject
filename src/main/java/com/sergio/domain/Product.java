package com.sergio.domain;

import javax.persistence.*;

/**
 * Class that represents POJO of product.
 */
@Entity
@Table(name="GOOD")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private int id;

	@Column(name = "TITLE", nullable = false)
	private String title;

	@Column(name="PRICE", nullable = false)
	private double price;

	public Product(int id, String title, double price) {
		this.id = id;
		this.title = title;
		this.price = price;
	}

	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
