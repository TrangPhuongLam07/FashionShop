package com.fashionShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fashionShop.entity.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, String>{

	@Query("select s.shoppingCartID from ShoppingCart s where s.customerID "
			+ "in (select c.customerID from Customer c where c.customerID = ?1) and s.state = 'buying' ")
	String getShoppingCartID(String customerID);

	

}
