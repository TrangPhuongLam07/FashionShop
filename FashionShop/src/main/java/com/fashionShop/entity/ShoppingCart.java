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
import javax.persistence.Table;

@Entity
@Table(name = "shoppingCart")
public class ShoppingCart {
	@Id
	@Column(name = "shopping_cart_ID", columnDefinition = "VARCHAR(10)")
	private String shoppingCartID;
	
	@ManyToOne
	@JoinColumn(name = "customer_ID", referencedColumnName = "customer_ID")
	private Customer customerID;
	
	@ManyToMany
	@JoinTable(name = "detailShopping",
			joinColumns = @JoinColumn(name = "shopping_cart_ID", referencedColumnName = "shopping_cart_ID"),
			inverseJoinColumns = @JoinColumn(name = "product_ID", referencedColumnName = "product_ID")
			)
	private List<Product> products = new ArrayList<Product>();
}
