package com.techefx.microservices.productstockservice.techefxpropertyaccessservice.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductStock {
	
	@Id
	private long id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_price")
	private BigDecimal productPrice;
	
	@Column(name="product_availability")
	private String productAvailability;
	
	@Column(name="product_discountoffer")
	private double discountOffer;

	public ProductStock() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductAvailability() {
		return productAvailability;
	}

	public void setProductAvailability(String productAvailability) {
		this.productAvailability = productAvailability;
	}

	public double getDiscountOffer() {
		return discountOffer;
	}

	public void setDiscountOffer(double discountOffer) {
		this.discountOffer = discountOffer;
	}
	
	
	
}
