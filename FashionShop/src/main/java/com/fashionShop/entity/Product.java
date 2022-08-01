package com.fashionShop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class Product {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_ID", columnDefinition = "VARCHAR(10)")
	private String productID;
	
	@ManyToOne
	@JoinColumn(name = "category_ID", referencedColumnName = "category_ID")
	private Categories categoryID;
	
	@Column(name = "product_name", columnDefinition = "VARCHAR(50)")
	private String productname;
	
	@Column(name = "price", columnDefinition = "BIGINT")
	private long price;
	
	@Column(name = "date_Import", columnDefinition = "DATE")
	private Date dateImport;
	
	@Column(name = "amount", columnDefinition = "INT")
	private int amount;
	
	@Column(name = "image", columnDefinition = "VARCHAR(255)")
	private String image;
	
	@OneToMany(mappedBy = "productID")
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	
	@OneToMany(mappedBy = "productID")
	private List<BillDetail> billDetails = new ArrayList<BillDetail>();
	
//	@ManyToMany(mappedBy = "products")
//	private List<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();

//	@ManyToMany(mappedBy = "products")
//	private List<Bill> bills = new ArrayList<Bill>();


//	public Product(Categories categoryID, String productname, long price, Date dateImport, int amount, String image,
//			List<ShoppingCart> shoppingCarts, List<Bill> bills) {
//		super();
//		this.categoryID = categoryID;
//		this.productname = productname;
//		this.price = price;
//		this.dateImport = dateImport;
//		this.amount = amount;
//		this.image = image;
////		this.shoppingCarts = shoppingCarts;
//		this.bills = bills;
//	}
	

	public Product() {
		super();
	}

	public Product(Categories categoryID, String productname, 
			long price, Date dateImport, int amount, String image) {
		super();
		this.categoryID = categoryID;
		this.productname = productname;
		this.price = price;
		this.dateImport = dateImport;
		this.amount = amount;
		this.image = image;
//		this.bills = bills;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public Categories getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Categories categoryID) {
		this.categoryID = categoryID;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Date getDateImport() {
		return dateImport;
	}

	public void setDateImport(Date dateImport) {
		this.dateImport = dateImport;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

//	public List<ShoppingCart> getShoppingCarts() {
//		return shoppingCarts;
//	}
//
//	public void setShoppingCarts(List<ShoppingCart> shoppingCarts) {
//		this.shoppingCarts = shoppingCarts;
//	}

//	public List<Bill> getBills() {
//		return bills;
//	}
//
//	public void setBills(List<Bill> bills) {
//		this.bills = bills;
//	}
//	
	
	
}

