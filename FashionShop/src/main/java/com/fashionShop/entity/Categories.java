package com.fashionShop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Categories {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_ID", columnDefinition = "VARCHAR(10)")
	private String categoryID;
	
	@Column(name = "category_name", columnDefinition = "VARCHAR(50)")
	private String categoryname;
	
	@Column(name = "category_type", columnDefinition = "VARCHAR(50)")
	private String categorytype;
	
	@OneToMany(mappedBy = "categoryID")
	private List<Product> products = new ArrayList<Product>();


	public Categories(String categoryname, String categorytype, List<Product> products) {
		super();
		this.categoryname = categoryname;
		this.categorytype = categorytype;
		this.products = products;
	}
	
	

	public Categories() {
		super();
	}



	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategorytype() {
		return categorytype;
	}

	public void setCategorytype(String categorytype) {
		this.categorytype = categorytype;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}