package com.fashionShop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "bill_detail")
public class BillDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
	private Bill billID;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "product_ID")
	private Product productID;
	
	private int quantity;

	public BillDetail(Bill billID, Product productID, int quantity) {
		super();
		this.billID = billID;
		this.productID = productID;
		this.quantity = quantity;
	}

	public BillDetail() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bill getBillID() {
		return billID;
	}

	public void setBillID(Bill billID) {
		this.billID = billID;
	}

	public Product getProductID() {
		return productID;
	}

	public void setProductID(Product productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
