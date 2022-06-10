package com.fashionShop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
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
}
