package com.techefx.microservices.productstockservice.techefxproductenquiryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techefx.microservices.productstockservice.techefxproductenquiryservice.beans.ProductEnquiryBean;
import com.techefx.microservices.productstockservice.techefxproductenquiryservice.client.ProductStockClient;

@RestController
public class ProductEnquiryController {
	@Autowired ProductStockClient client;
	
	@GetMapping("/product-enquiry/name/{name}/availability/{availability}/unit/{unit}")
	public ProductEnquiryBean getEnquiryOfProduct(@PathVariable String name, @PathVariable String availability, @PathVariable int unit) {
		
		ProductEnquiryBean productEnquiryBean = client.checkProdutStock(name, availability);
		
		double totalPrice = productEnquiryBean.getProductPrice().doubleValue()*unit; 
		double discounts = productEnquiryBean.getDiscountOffer();
		double discountPrice = totalPrice-totalPrice*discounts/100;
		
		return new ProductEnquiryBean(
				productEnquiryBean.getId()
				, name
				, productEnquiryBean.getProductPrice()
				, availability
				, productEnquiryBean.getDiscountOffer()
				, unit
				, discountPrice
				, productEnquiryBean.getPort()
		);
	}
}
