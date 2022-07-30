package com.fashionShop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "shoppingCart_ID", referencedColumnName = "shoppingCart_ID")
	private ShoppingCart shoppingCartID;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "product_ID")
	private Product productID;
	
//	@ManyToOne
//	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
//	private Customer customer;
	
	private int quantity;
	
	

	public CartItem(Integer id, ShoppingCart shoppingCartID, Product productID, int quantity) {
		super();
		this.id = id;
		this.shoppingCartID = shoppingCartID;
		this.productID = productID;
		this.quantity = quantity;
	}

	public CartItem(ShoppingCart shoppingCartID, Product productID, int quantity) {
		super();
		this.shoppingCartID = shoppingCartID;
		this.productID = productID;
		this.quantity = quantity;
	}
	
	
	public CartItem() {
		super();
	}

	public ShoppingCart getShoppingCartID() {
		return shoppingCartID;
	}

	public void setShoppingCartID(ShoppingCart shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return productID;
	}

	public void setProduct(Product productID) {
		this.productID = productID;
	}

	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
