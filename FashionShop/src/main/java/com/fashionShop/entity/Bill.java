package com.fashionShop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@Column(name = "bill_ID", columnDefinition = "VARCHAR(10)")
	private String billID;
	
	@ManyToOne
	@JoinColumn(name = "payment_ID", referencedColumnName = "payment_ID")
	private Payment paymentID;
	
	@ManyToOne
	@JoinColumn(name = "customer_ID", referencedColumnName = "customer_ID")
	private Customer customerID;
	
	@Column(name = "date_create", columnDefinition = "DATE")
	private Date dateCreate;
	
	@Column(name = "total", columnDefinition = "BIGINT")
	private long total;
	
	@ManyToMany
	@JoinTable(name = "detailBill",
			joinColumns = @JoinColumn(name = "bill_ID", referencedColumnName = "bill_ID"),
			inverseJoinColumns = @JoinColumn(name = "product_ID", referencedColumnName = "product_ID")
			)
	private List<Product> products = new ArrayList<Product>();
	
}
