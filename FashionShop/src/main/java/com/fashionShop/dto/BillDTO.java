package com.fashionShop.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fashionShop.entity.Customer;
import com.fashionShop.entity.Payment;

public class BillDTO {
	private String recipientName;
	
	private String phone;
	
	private String address;
	
	private String notes;
	
	private Payment paymentID;
	
	private Date dateCreate;
	
	private long total;

	public BillDTO(String recipientName, String phone, String address, String notes, Payment paymentID, Date dateCreate,
			long total) {
		super();
		this.recipientName = recipientName;
		this.phone = phone;
		this.address = address;
		this.notes = notes;
		this.paymentID = paymentID;
		this.dateCreate = dateCreate;
		this.total = total;
	}

	public BillDTO() {
		super();
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
	
	
}
