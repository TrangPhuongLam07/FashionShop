package com.fashionShop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fashionShop.entity.Account;
import com.fashionShop.entity.Customer;
import com.fashionShop.service.AccountService;
import com.fashionShop.service.CustomerService;

@Controller
public class SignUpController {
	private final AccountService accountService;
	private final CustomerService customerService;

	@Autowired
	public SignUpController(AccountService accountService, CustomerService customerService) {
		super();
		this.accountService = accountService;
		this.customerService = customerService;
	}
	
//	@RequestMapping("/signUp")
//	public String process_signUp(Model model, @RequestParam String name, @RequestParam String email, @RequestParam String pass, @RequestParam String re_pass) {
//		Account account = new Account(name, pass, "user");
//		accountService.save(account);
//		return "/signUp/signUp";
//	}
	
	@RequestMapping(value= "/login", method= RequestMethod.POST)
	public String process_login(@RequestParam("name") String name, @RequestParam("pass") String pass, 
			HttpSession session) {
		System.out.println("Account name " + name + " " + pass);
		
		String customerID = accountService.getCustomerID(name);
		session.setAttribute("customerID", "CUS003");
//		Account account = new Account(name, pass, "user");
//		accountService.save(account);
		//check accountName is exist
		//
		return "/home/index";
	}
	
	

	@RequestMapping(value= "/signUp", method= RequestMethod.POST)
	public String process_signUp(@RequestParam("name") String name, @RequestParam("account") String accountName, @RequestParam("email") String email, @RequestParam("pass") String pass, @RequestParam("re_pass") String re_pass) {
		System.out.println("Account name " + accountName + " " + pass);
		//check accountName is exist
		//Save customer
		Customer customer = new Customer(name, email, null, null, null);
		customerService.save(customer);
		//take customerID 
		//save account
		Account account = new Account(accountName, pass, "user");
		accountService.save(account);
		return "/Login/login";
	}
	
}
