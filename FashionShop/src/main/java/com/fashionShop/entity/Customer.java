package com.fashionShop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "customer_ID", columnDefinition = "VARCHAR(10)")
	private String customerID;
	
	@Column(name = "customer_name", columnDefinition = "VARCHAR(50)")
	private String customerName;
	
	@Column(name = "email", columnDefinition = "VARCHAR(50)")
	private String email;
	
	@Column(name = "address", columnDefinition = "VARCHAR(100)")
	private String address;
	
	@Column(name = "number_phone", columnDefinition = "VARCHAR(50)")
	private String numberPhone;
	
	@Column(name = "number_account_bank", columnDefinition = "VARCHAR(50)")
	private String numberAccountBank;
	
	@OneToMany(mappedBy = "customerID")
	private List<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();
	
	@OneToOne(mappedBy = "customerID")
	private Account account;
	
	@OneToMany(mappedBy = "customerID")
	private List<Bill> bills = new ArrayList<Bill>();
	
}

