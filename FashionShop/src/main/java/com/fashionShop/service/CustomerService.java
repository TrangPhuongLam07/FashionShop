package com.fashionShop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fashionShop.entity.Account;
import com.fashionShop.entity.Customer;
import com.fashionShop.repository.CustomerRepository;

@Service
public class CustomerService {

	private final CustomerRepository customerRepo;

	@Autowired
	public CustomerService(CustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}
	
	public void save(Customer customer) {
		 //find student by email in database
//	       Optional<Account> accountOptional = accountRepo
//	                .findStudentByName(account.getAccountname());
//
//	       //test student is exists or not
//	       if (accountOptional.isPresent()){
//	           throw new IllegalStateException("Account  Taken");
//	        }
		 customerRepo.save(customer);
		
	}

	public String getCustomerID(String accountName) {
		// TODO Auto-generated method stub
		return customerRepo.getCustomerID(accountName);
	}

	public void setAccountNameByCustomerID(String customerID, String accountName) {
		// TODO Auto-generated method stub
		customerRepo.setAccountNameByCustomerID(customerID, accountName);
	}

	public String getEmailByCustomerID(String customerID) {
		// TODO Auto-generated method stub
		return customerRepo.getEmailByCustomerID(customerID);
	}

	

	
	
//	public Customer getCurrentlyLoggedInCustomer(Authentication authentication) {
//		if (authentication == null) return null;
//		
//		Customer customer = null;
//		System.out.println("customer services getCurrentlyLoggedInCustomer");
//		Object principal = authentication.getPrincipal();
//		
//		if (principal instanceof CustomerUserDetails) {
//			customer = ((CustomerUserDetails) principal).getCustomer();
//			
//		}else if (principal instanceof CustomOAuth2User) {
//			String email = ((CustomOAuth2User) principal).getEmail();
//			customer = getCustomerByEmail(email);
//		}
		
//		return customer;
//	}
	
}
