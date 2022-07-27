package com.techefx.microservices.techefxpropertyaccessservice.controller;

import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.techefx.microservices.techefxpropertyaccessservice.beans.PropertyAccessBean;
import com.techefx.microservices.techefxpropertyaccessservice.beans.PropertyAccessValue;

@RestController
@RequestMapping("/access")
public class PropertyFileAccessController {

	@Autowired PropertyAccessBean propertyAccessBean;
	
	@GetMapping("accessPropertyFile")
	public PropertyAccessValue accessPropertyFile() {
		return new PropertyAccessValue(propertyAccessBean.getName(), propertyAccessBean.getDescription());
	}
	
	public void refreshActuator() {
		RestTemplate resTemplate=new RestTemplate();
		final String baseUrl="";
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type","application/json");
		HttpEntitiy entity = new HttpEntity(headers);
		
		ResponseEntity<String> results=RestTemplate.postForEntity(baseUrl,entity,String.class);
	}
}
