package com.fashionShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionShop.entity.CartItem;
import com.fashionShop.entity.Customer;
import com.fashionShop.entity.Product;
import com.fashionShop.entity.ShoppingCart;
import com.fashionShop.repository.CartItemRepository;
import com.fashionShop.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServices {
	@Autowired
	private CartItemRepository cartRepo;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepo;
	
	public List<CartItem> listCartItems(String shoppingCartID){
		return cartRepo.findByShoppingCartID(shoppingCartID);
	}

	public String getShoppingCartID(String customerID) {
	
		return shoppingCartRepo.getShoppingCartID(customerID);
	}

	public void deleteCartItem(String productID) {
		cartRepo.deleteItemByID(productID);
		
	}

	public void addCartItem(int quantity, String productID, String shoppingCartID) {
//		cartRepo.addItem(quantity, productID, shoppingCartID);
		cartRepo.deleteItemByID(productID);
//		CartItem cartItem = new CartItem();
		
		
	}

	public void save(int quantity, String productID, String customerID) {
		//find shoppingCartID by customerID
		String shoppingCartID = shoppingCartRepo.getShoppingCartID(customerID);
		
		//set attribute of cartItem
		Product product = new Product();
		product.setProductID(productID);
		
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setShoppingCartID(shoppingCartID);
		
		
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(quantity);
		cartItem.setProduct(product);
		cartItem.setShoppingCartID(shoppingCart);
		cartRepo.save(cartItem);
		
	}

	public void saveShoppingCart(Customer customer) {
		// TODO Auto-generated method stub
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setCustomerID(customer);
		shoppingCart.setState("buying");
		shoppingCartRepo.save(shoppingCart);
		
	}

	public void paidBill(String customerID) {
		// TODO Auto-generated method stub
		//set buying = paid for customer's cart
		shoppingCartRepo.setpaidCartByCustomerID(customerID);
		//create shopping cart by customer id
		Customer customer = new Customer();
		customer.setCustomerID(customerID);
		saveShoppingCart(customer);
		
	}

	

}
