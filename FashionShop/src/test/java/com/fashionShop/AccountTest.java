package com.fashionShop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.fashionShop.entity.Account;
import com.fashionShop.entity.Customer;
import com.fashionShop.repository.AccountRepository;
import com.fashionShop.service.AccountService;
import com.fashionShop.service.CustomerService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AccountTest {

	private final AccountService accountService;
	
	private final CustomerService customerService;
	
	private final AccountRepository accountRepo;
	
	@Autowired
	public AccountTest(AccountService accountService, CustomerService customerService, AccountRepository accountRepo) {
		super();
		this.accountService = accountService;
		this.customerService = customerService;
		this.accountRepo = accountRepo;
	}


	@Test
	public void setCustomerIDByAccountname() {
		String accountName = "Hello";
		String pass = "123";
		
		String name = "Lâm Phương Trang";
		String email = "phuongtrang112200@gmail.com";
		//save customer
//				Account account = new Account(accountName, pass, "user");
//				accountService.save(account);
//				
//				Customer customer = new Customer(name, email, null, null, null, account);
//				customerService.save(customer);
				//take customer id
//				String customerID = customerService.getCustomerID("Hello");
//				System.out.println("CustomerID: " + customerID);
				//Save account
//				Customer customer2 = new Customer(customerID, name, email, null, null, null, account);
//				customer.setCustomerID(customerID);
				accountService.setCustomeIDByAccountname("CUS00083", accountName);
//				customerService.setAccountNameByCustomerID(customerID, accountName);
	}
}
