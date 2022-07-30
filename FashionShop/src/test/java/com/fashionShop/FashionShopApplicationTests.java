package com.fashionShop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class FashionShopApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testAddOneCartItem() {
//		Product product = entityManager.find(Product.class, "PD006");
//		Customer customer = entityManager.find(Customer.class, "CUS003");
//		
//		CartItem newItem = new CartItem();
//		newItem.setCustomer(customer);
//		newItem.setProduct(product);
//		newItem.setQuantity(1);
//		
//		CartItem savedCartItem = cartRepo.save(newItem);
//		assertTrue(savedCartItem.getId() > 0);
		System.out.println("Hello");
	}

}
