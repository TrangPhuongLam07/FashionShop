package com.fashionShop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "shoppingCart")
public class ShoppingCart {
	@Id
	@Column(name = "shoppingCart_ID", columnDefinition = "VARCHAR(10)")
	private String shoppingCartID;
	
	@ManyToOne
	@JoinColumn(name = "customer_ID", referencedColumnName = "customer_ID")
	private Customer customerID;
	
	private String state;
	
	@OneToMany(mappedBy = "shoppingCartID")
	private List<CartItem> cartItems = new ArrayList<CartItem>();

	public ShoppingCart(Customer customerID, String state, List<CartItem> cartItems) {
		super();
		this.customerID = customerID;
		this.state = state;
		this.cartItems = cartItems;
	}

	public ShoppingCart() {
		super();
	}

	public String getShoppingCartID() {
		return shoppingCartID;
	}

	public void setShoppingCartID(String shoppingCartID) {
		this.shoppingCartID = shoppingCartID;
	}

	public Customer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Customer customerID) {
		this.customerID = customerID;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
//	@ManyToMany
//	@JoinTable(name = "detailShopping",
//			joinColumns = @JoinColumn(name = "shopping_cart_ID", referencedColumnName = "shopping_cart_ID"),
//			inverseJoinColumns = @JoinColumn(name = "product_ID", referencedColumnName = "product_ID")
//			)
//	private List<Product> products = new ArrayList<Product>();
	
}
