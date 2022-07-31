package com.fashionShop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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
	
	@Column(name = "customer_ID", columnDefinition = "VARCHAR(10)")
	private String customerID;
	
	
	@Column(name = "password", columnDefinition = "VARCHAR(500)")
	private String password;
	
	@Column(name = "role", columnDefinition = "VARCHAR(20)")
	private String role;
	
	@OneToOne(mappedBy = "accountname")
	private Customer customer;

	
	public Account(String accountname, String password, String role, String customerID) {
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

	public String getCustomerID() {
		return customerID;
	}


	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	
}
