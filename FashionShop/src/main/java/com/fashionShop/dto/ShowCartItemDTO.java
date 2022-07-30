package com.fashionShop.dto;

public class ShowCartItemDTO {
	private String productID;
	private String productname;
	private long price;
	private String image;
	private int quantity;
	
	
	public ShowCartItemDTO(String productID, String productname, long price, String image, int quantity) {
		super();
		this.productID = productID;
		this.productname = productname;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
	}

	public ShowCartItemDTO() {
		super();
	}
	
	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
