package com.fashionShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionShop.entity.Product;
import com.fashionShop.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepo;
	
	@Autowired
	public ProductService(ProductRepository productRepo) {
		super();
		this.productRepo = productRepo;
	}


	public Object getProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}


	public List<Product> getProductTest() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

}
