package com.fashionShop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Account {
	@Id
	@Column(name = "account_name", columnDefinition = "VARCHAR(50)")
	private String accountname;
	
	@Column(name = "password", columnDefinition = "VARCHAR(500)")
	private String password;
	
	@Column(name = "role", columnDefinition = "VARCHAR(20)")
	private String role;
	
	@OneToOne
	@JoinColumn(name = "customer_ID")
	private Customer customerID;

	public Account(String accountname, String password, String role, Customer customerID) {
		super();
		this.accountname = accountname;
		this.password = password;
		this.role = role;
		this.customerID = customerID;
	}
	

	public Account(String accountname, String password, String role) {
		super();
		this.accountname = accountname;
		this.password = password;
		this.role = role;
	}



	public Account() {
		super();
	}



	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public Customer getCustomerID() {
		return customerID;
	}
	
	
}
