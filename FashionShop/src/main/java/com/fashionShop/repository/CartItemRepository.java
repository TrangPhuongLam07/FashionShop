package com.fashionShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fashionShop.entity.CartItem;
import com.fashionShop.entity.Customer;
import com.fashionShop.entity.ShoppingCart;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

	@Query("select c from CartItem c where c.shoppingCartID "
			+ "in (select s.shoppingCartID from ShoppingCart s where s.shoppingCartID = ?1) ")
	 List<CartItem> findByShoppingCartID(String shoppingCartID);

	@Transactional
	@Modifying
	@Query("delete from CartItem c where c.productID "
			+ "in (select p.productID from Product p where p.productID = ?1) ")
	void deleteItemByID(String productID);

//	@Modifying
//	@Query("insert into CartItem (quantity) values (2)")
//	void addItem(int quantity, String productID, String shoppingCartID);

//	@Transactional
//	@Modifying
//	@Query("insert into CartItem (quantity)  values (2)")
//	void addItem(int quantity);
	
	
}
