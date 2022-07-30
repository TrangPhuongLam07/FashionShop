package com.fashionShop.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fashionShop.entity.Account;
import com.fashionShop.entity.Product;
import com.fashionShop.service.ProductService;

@Controller
//@RequestMapping("/Home")
public class HomeController {
	
	private final ProductService productService;
	
	
	@Autowired
	public HomeController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		
		return listByPage(model, 1);
	}
	
	@RequestMapping("/products")
	public ResponseEntity<Iterable<Product>> findAll(){
		return new ResponseEntity<Iterable<Product>>(productService.findAll(), HttpStatus.OK);
	}
	
//	@GetMapping(path = "{pageNumber}")
	@RequestMapping(value= "{pageNumber}", method = RequestMethod.GET)
	public String listByPage(Model model, @PathVariable("pageNumber") int currentPage) {
		System.out.println("current page......"+currentPage);
		
		Page<Product> page = productService.listAll(currentPage);
//		Page<Product> page = productService.listAll(currentPage, "Áo");
//		Page<Product> pageQuan = productService.listAll(currentPage, "Quan");
//		Page<Product> pageTui = productService.listAll(currentPage, "Tui");
//		Page<Product> pageNon = productService.listAll(currentPage, "Non");
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		
//		List<Product> lisProducts = page.getContent();
		List<Product> listProducts = page.getContent();
//		List<Product> listProductsQuan = pageQuan.getContent();
//		List<Product> listProductsTui = pageTui.getContent();
//		List<Product> listProductsNon = pageNon.getContent();
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("listProducts", listProducts);
//		model.addAttribute("listProductsQuan", listProductsQuan);
//		model.addAttribute("listProductsTui", listProductsTui);
//		model.addAttribute("listProductsNon", listProductsNon);
		return "/home/index";
	}
	
	
	
	
	@RequestMapping("/home")
	public ModelAndView getProducts() {
		ModelAndView mv = new ModelAndView("/home/index");
		mv.addObject("list", productService.getProduct());
		return mv;
	}
	
//	@GetMapping("/home")
//	public String viewHomePage(Model model) {
//		return findPaginated(1, model);
//	}
	
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
	
	@RequestMapping("/detailProduct")
	public String detailProduct() {
		return "/product/detail-product";
	}
	
//	@RequestMapping("/shoppingCart")
//	public String shoppingCart() {
//		return "/shoppingCart/shopping-cart";
//	}
	
	@RequestMapping(value= "/login", method= RequestMethod.GET)
	public String login() {
		return "/Login/login";
	}
	
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp() {
	
		return "/signUp/signUp";
	}
	
	
	
	@GetMapping("/page/{pageNO}")
	public String findPaginated (@PathVariable(value = "pageNO") int pageNO, Model model) {
		int pageSize = 5;
		
		Page<Product> page = productService.findPaginated(pageNO, pageSize);
		List<Product> listProduct = page.getContent();
		
		model.addAttribute("currentPage", pageNO);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("toatlItems", page.getTotalElements());
		model.addAttribute("listProduct", listProduct);
		
		return "/home/index";
	}
	
	
}
