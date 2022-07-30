package com.fashionShop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import com.fashionShop.entity.CartItem;
import com.fashionShop.entity.Customer;
import com.fashionShop.entity.Product;
import com.fashionShop.repository.CartItemRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class ShoppingCartTest {
	@Autowired
	private CartItemRepository cartRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testAddOneCartItem() {
//		Product product = entityManager.find(Product.class, "PD006");
//		Customer customer = entityManager.find(Customer.class, "CUS003");
//		
//		CartItem newItem = new CartItem();
////		newItem.setCustomer(customer);
//		newItem.setProduct(product);
//		newItem.setQuantity(1);
//		
////		CartItem savedCartItem = cartRepo.save(newItem);
//		assertTrue(savedCartItem.getId() > 0);
//		System.out.println("Hello");
	}
	
	@Test
	public void testGetCartItemsByCustomer() {
		Customer customer = new Customer();
		customer.setCustomerID("CUS003");
		
//		List<CartItem> cartItems = cartRepo.findByCustomer(customer);
		
//		assertEquals(1, cartItems.size());
	}

}
