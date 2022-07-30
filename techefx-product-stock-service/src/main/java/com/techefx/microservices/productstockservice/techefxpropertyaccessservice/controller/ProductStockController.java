package com.techefx.microservices.productstockservice.techefxpropertyaccessservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techefx.microservices.productstockservice.techefxpropertyaccessservice.beans.ProductStockBean;
import com.techefx.microservices.productstockservice.techefxpropertyaccessservice.entity.ProductStock;
import com.techefx.microservices.productstockservice.techefxpropertyaccessservice.entity.ProductStockRepository;

@RestController
public class ProductStockController {
	@Autowired Environment environment;
	@Autowired ProductStockRepository repository;
	
	@GetMapping("/check-product-stock/productName/{productName}/productAvailability/{productAvailability}")
	public ProductStockBean checkProdutStock(@PathVariable String productName, @PathVariable String productAvailability) {
		
		ProductStock productStock = repository.findByProductNameAndProductAvailability(productName, productAvailability);
		ProductStockBean productStockBean = new ProductStockBean(
				productStock.getId()
				, productStock.getProductName()
				, productStock.getProductPrice()
				, productStock.getProductAvailability()
				, productStock.getDiscountOffer()
				, Integer.parseInt(environment.getProperty("local.server.port"))
		);
		
		return productStockBean;
	}
}
