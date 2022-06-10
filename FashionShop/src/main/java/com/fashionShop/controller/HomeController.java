package com.fashionShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fashionShop.service.ProductService;

@Controller
//@RequestMapping("/hello")
public class HomeController {
	
	private final ProductService productService;
	
	@Autowired
	public HomeController(ProductService productService) {
		super();
		this.productService = productService;
	}

//	@RequestMapping("/home")
//	public String hello() {
//		return "/home/index";
//	}
	
	@RequestMapping("/home")
	public ModelAndView getProducts() {
		ModelAndView mv = new ModelAndView("/home/index");
		mv.addObject("list", productService.getProduct());
		return mv;
	}
	
	@RequestMapping("/blog")
	public String blog() {
		return "/blog/blog";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "/contact/contact";
	}
	
	@RequestMapping("/saleOff")
	public String saleOff() {
		return "/saleOff/sale-off";
	}
}
