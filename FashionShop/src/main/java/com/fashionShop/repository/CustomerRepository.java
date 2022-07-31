package com.fashionShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fashionShop.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{
	@Query("select c.customerID from Customer c where c.accountname "
			+ "in (select a.accountname from Account a where a.accountname = ?1)" )
	String getCustomerID(String accountName);
	
	@Transactional
	@Modifying
	@Query("update Customer c set c.accountname  = (select a.accountname from Account a where a.accountname = ?2) "
			+ "where c.customerID = ?1")
	void setAccountNameByCustomerID(String customerID, String accountName);

}
