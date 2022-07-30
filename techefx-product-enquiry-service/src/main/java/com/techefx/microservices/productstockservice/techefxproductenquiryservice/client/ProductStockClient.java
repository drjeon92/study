package com.techefx.microservices.productstockservice.techefxproductenquiryservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.techefx.microservices.productstockservice.techefxproductenquiryservice.beans.ProductEnquiryBean;

@FeignClient(name="techefx-product-stock-service", url="localhost:8800")
public interface ProductStockClient {
	@GetMapping("/check-product-stock/productName/{productName}/productAvailability/{productAvailability}")
	public ProductEnquiryBean checkProdutStock(@PathVariable("productName") String productName, @PathVariable("productAvailability") String productAvailability);
}
