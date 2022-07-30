package com.fashionShop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionShop.entity.Account;
import com.fashionShop.repository.AccountRepository;

@Service
public class AccountService {
	private final AccountRepository accountRepo;
	
	
	@Autowired
	public AccountService(AccountRepository accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}

	public void save(Account account) {
		 //find student by email in database
//	       Optional<Account> accountOptional = accountRepo
//	                .findStudentByName(account.getAccountname());
//
//	       //test student is exists or not
//	       if (accountOptional.isPresent()){
//	           throw new IllegalStateException("Account  Taken");
//	        }
		 accountRepo.save(account);
		
	}

	public String getCustomerID(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
