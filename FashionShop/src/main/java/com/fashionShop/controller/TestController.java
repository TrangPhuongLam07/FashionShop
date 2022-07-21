package com.fashionShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashionShop.entity.Product;
import com.fashionShop.service.ProductService;

@RestController
@RequestMapping(path = "/test")
public class TestController {

	private final ProductService productService;

	@Autowired
	public TestController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	  @GetMapping
	    public List<Product> getStudent(){

	        return productService.findAllProduct();
	    }
	
}
