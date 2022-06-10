package com.fashionShop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	@Id
	@Column(name = "payment_ID", columnDefinition = "VARCHAR(10)")
	private String paymentID;
	
	@Column(name = "payment_name", columnDefinition = "VARCHAR(50)")
	private String paymentName;
	
	@OneToMany(mappedBy = "paymentID")
	private List<Bill> bills = new ArrayList<Bill>();
}
