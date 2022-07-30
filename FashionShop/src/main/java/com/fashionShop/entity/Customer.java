package com.fashionShop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "customer")
public class Customer {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fashion_shop")
	@GenericGenerator(name = "fashion_shop", strategy = "com.fashionShop.entity.StringPrefixSequenceGenerator", parameters = {
			@Parameter(name = StringPrefixSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "CUS"),
			@Parameter(name = StringPrefixSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
	})
	
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
	
	

	public Customer(String customerName, String email, String address, String numberPhone, String numberAccountBank) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.address = address;
		this.numberPhone = numberPhone;
		this.numberAccountBank = numberAccountBank;
	}
	
	

	public Customer() {
		super();
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getNumberAccountBank() {
		return numberAccountBank;
	}

	public void setNumberAccountBank(String numberAccountBank) {
		this.numberAccountBank = numberAccountBank;
	}

	public List<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}

	public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	
	
	
}

