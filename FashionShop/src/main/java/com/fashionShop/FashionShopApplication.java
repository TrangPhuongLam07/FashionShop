package com.fashionShop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fashionShop.dto.APIReponse;
import com.fashionShop.entity.Product;
import com.fashionShop.service.ProductService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@SpringBootApplication
//@RestController
//@RequestMapping(path = "/products")
//@JsonAutoDetect(getterVisibility=Visibility.NONE)
//@Controller
public class FashionShopApplication {

//	@Autowired
//	private ProductService productService;
//	
//	@GetMapping( produces="application/json")
//	private APIReponse<List<Product>> getProducts(){
//		List<Product> allProducts = productService.findAllProduct();
//		return new APIReponse<>(allProducts.size(), allProducts);
//		
//	}
//	
//	@GetMapping("/{field}")
//	private APIReponse<List<Product>> getProductsWithSort(@PathVariable String field){
//		List<Product> allProducts = productService.findProductsWithSorting(field);
//		return new APIReponse<>(allProducts.size(), allProducts);
//		
//	}
//	@GetMapping(produces="application/json")
//	public List<Product> getbook(){
//		return productService.findAllProduct();
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(FashionShopApplication.class, args);
	}

//	@ResponseBody
//	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
//	public String handleHttpMediaTypeNotAcceptableException() {
//	    return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
//	}
}
