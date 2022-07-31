package com.fashionShop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fashionShop.entity.Account;
import com.fashionShop.entity.Product;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{
	@Query("select a from Account a where a.accountname = ?1" )
   Account findByName(String name);

	@Transactional
	@Modifying
	@Query("update Account a set a.customerID = (select c.customerID from Customer c where c.customerID = ?1 ) "
			+ "where a.accountname = ?2")
	void setCustomeIDByAccountname(String customerID, String accountName);

	@Query("select a from Account a where a.accountname = ?1" )
	Optional<Account> findByNameOptional(String accountName);

	@Query("select a.accountname from Account a where a.customerID = ?1")
	String getAccountname(String customerID);

	@Query("select a.customerID from Account a where a.accountname = ?1")
	String getCustomerID(String name);

	
//	@Query("select a from Product p where p.productID = 'PD001' ")
//    List<Product> getProducts();
	
}
