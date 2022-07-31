package com.fashionShop.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fashionShop.entity.Account;
import com.fashionShop.entity.Customer;
import com.fashionShop.entity.Product;
import com.fashionShop.service.AccountService;
import com.fashionShop.service.CustomerService;
import com.fashionShop.service.ProductService;
import com.fashionShop.service.ShoppingCartServices;

@Controller
public class SignUpController {
	private final AccountService accountService;
	private final CustomerService customerService;
	private final ProductService productService;
	private final ShoppingCartServices shoppingCartServices;

	@Autowired
	public SignUpController(AccountService accountService, CustomerService customerService,
			ProductService productService, ShoppingCartServices shoppingCartServices) {
		super();
		this.accountService = accountService;
		this.customerService = customerService;
		this.productService = productService;
		this.shoppingCartServices = shoppingCartServices;
	}
	
//	@RequestMapping("/signUp")
//	public String process_signUp(Model model, @RequestParam String name, @RequestParam String email, @RequestParam String pass, @RequestParam String re_pass) {
//		Account account = new Account(name, pass, "user");
//		accountService.save(account);
//		return "/signUp/signUp";
//	}
	
	@RequestMapping(value= "/login", method= RequestMethod.GET)
	public String login() {
		return "/Login/login";
	}
	
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String signUp() {
	
		return "/signUp/signUp";
	}
	
//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public String home_login(Model model) {
//	
//		return "/home/index_login";
//	}
	
	
	
	@RequestMapping(value = "/logout/{customerID}/{accountname}", method = RequestMethod.GET)
	public String logout(@PathVariable("customerID") String customerID, 
			@PathVariable("accountname") String accountname, 
			HttpServletRequest servletRequest) {
		HttpSession session = servletRequest.getSession(false);
		if (session != null) {
	        servletRequest.getSession(true).invalidate();
	    }
//		session.removeAttribute(customerID);
//		session.removeAttribute(accountname);
		return "redirect:/";
	}
	
	
	@RequestMapping(value= "/login", method= RequestMethod.POST)
	public String process_login(@RequestParam("name") String name, @RequestParam("pass") String pass, 
			HttpSession session) {
		System.out.println("Account name " + name + " " + pass);
		Account accountCheck = accountService.findByName(name);
		if(accountCheck != null) {
			String customerID = accountService.getCustomerID(name);
			String accountname = accountService.getAccountname(customerID);
			System.out.println("accountname: " + accountname);
			System.out.println("customerID: " + customerID);
			
			session.setAttribute("customerID", customerID);
			session.setAttribute("accountname", accountname);
			return "redirect:/";
		}
		
//		Account account = new Account(name, pass, "user");
//		accountService.save(account);
		//check accountName is exist
		//
		return "redirect:/login";
	}
	
	

	@RequestMapping(value= "/signUp", method= RequestMethod.POST)
	public String process_signUp(@RequestParam("name") String name, @RequestParam("account") String accountName, @RequestParam("email") String email, @RequestParam("pass") String pass, @RequestParam("re_pass") String re_pass) {
		System.out.println("Account name " + accountName + " " + pass);
		//check accountName is exist
		Account accountCheck = accountService.findByName(accountName);
		Optional<Account> accountOptional = accountService.findByNameOptional(accountName);
		System.out.println("accountcheck " +accountCheck);
		
		if (accountCheck == null) {
			//save customer
			Account account = new Account(accountName, pass, "user");
			accountService.save(account);
			
			Customer customer = new Customer(name, email, null, null, null, account);
			customerService.save(customer);
			//take customer id
			String customerID = customerService.getCustomerID(accountName);
			//Save account
			accountService.setCustomeIDByAccountname(customerID, accountName);
			System.out.println("sigup to login");
			
			//create shopping cart
			shoppingCartServices.saveShoppingCart(customer);
			
			return "redirect:/login";
			
			
			
		}
		
		return "redirect:/signUp";
	}
	
}
