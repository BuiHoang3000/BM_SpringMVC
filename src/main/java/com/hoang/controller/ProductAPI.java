package com.hoang.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoang.model.Product;

@RestController
public class ProductAPI {
	
	private ApplicationContext context = null;
	private ConJDBC prJDBC = null;
	
	private ProductAPI() {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		prJDBC = (ConJDBC) context.getBean("conJDBC");
	}
	
	@GetMapping(value = "/apiPr/{id}")
	public List<Product> getProduct(@PathVariable(name = "id") String id) {
		List<Product> pr = prJDBC.getProductUpdate(id);	
		return pr;
	}
	
	@PostMapping(value = "/apiPr")
	public Product createProduct(@RequestBody Product pr) {
		
		return pr;
	}
	
	@PutMapping(value = "/apiPr")
	public Product updateProduct(@RequestBody Product pr) {
		return pr;
	}
	
	@DeleteMapping(value = "/apiPr")
	public void deleteProduct(@RequestBody long[] ids) {}
}
