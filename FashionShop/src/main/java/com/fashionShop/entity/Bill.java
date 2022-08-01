package com.fashionShop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "bill")
public class Bill {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fashion_shop")
	@GenericGenerator(name = "fashion_shop", strategy = "com.fashionShop.entity.StringPrefixSequenceGenerator", parameters = {
			@Parameter(name = StringPrefixSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "B"),
			@Parameter(name = StringPrefixSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
	})
	@Id
	@Column(name = "bill_ID", columnDefinition = "VARCHAR(10)")
	private String billID;
	
	@Column(name = "recipient_name", columnDefinition = "VARCHAR(50)")
	private String recipientName;
	
	@Column(name = "phone", columnDefinition = "VARCHAR(11)")
	private String phone;
	
	@Column(name = "address", columnDefinition = "VARCHAR(255)")
	private String address;
	
	@Column(name = "notes", columnDefinition = "VARCHAR(255)")
	private String notes;
	
	@Column(name = "count_buy", columnDefinition = "INT")
	private int countBuy;
	
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
	
	@OneToMany(mappedBy = "billID")
	private List<BillDetail> billDetails = new ArrayList<BillDetail>();
//	@ManyToMany
//	@JoinTable(name = "detailBill",
//			joinColumns  = @JoinColumn(name = "bill_ID", referencedColumnName = "bill_ID"),
//			inverseJoinColumns = @JoinColumn(name = "product_ID", referencedColumnName = "product_ID")
//			
//			)
//	
//	private List<Product> products = new ArrayList<Product>();

	public Bill(String recipientName, String phone, String address, String notes, Payment paymentID,
			Customer customerID, Date dateCreate, long total) {
		super();
		this.recipientName = recipientName;
		this.phone = phone;
		this.address = address;
		this.notes = notes;
		this.paymentID = paymentID;
		this.customerID = customerID;
		this.dateCreate = dateCreate;
		this.total = total;
	}
public Bill() {
	super();
}
public String getBillID() {
	return billID;
}
public void setBillID(String billID) {
	this.billID = billID;
}
public String getRecipientName() {
	return recipientName;
}
public void setRecipientName(String recipientName) {
	this.recipientName = recipientName;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}
public Payment getPaymentID() {
	return paymentID;
}
public void setPaymentID(Payment paymentID) {
	this.paymentID = paymentID;
}
public Customer getCustomerID() {
	return customerID;
}
public void setCustomerID(Customer customerID) {
	this.customerID = customerID;
}
public Date getDateCreate() {
	return dateCreate;
}
public void setDateCreate(Date dateCreate) {
	this.dateCreate = dateCreate;
}
public long getTotal() {
	return total;
}
public void setTotal(long total) {
	this.total = total;
}
public List<BillDetail> getBillDetails() {
	return billDetails;
}
public void setBillDetails(List<BillDetail> billDetails) {
	this.billDetails = billDetails;
}
public int getCountBuy() {
	return countBuy;
}
public void setCountBuy(int countBuy) {
	this.countBuy = countBuy;
}
	
	
	
}
