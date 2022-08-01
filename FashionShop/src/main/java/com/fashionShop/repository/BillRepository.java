package com.fashionShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fashionShop.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, String>{

	@Query("select b.billID from Bill b where b.customerID "
			+ "in (select c.customerID from Customer c where c.customerID = ?1) and "
			+ "b.countBuy in (select max(b.countBuy) from Bill b where b.customerID "
			+ "in (select c.customerID from Customer c where c.customerID = ?1))")
	String getBillIDByCustomerID(String customerID);

	@Query("select max(b.countBuy) from Bill b where b.customerID "
			+ "in (select c.customerID from Customer c where c.customerID = ?1)")
	int getCountBuyRecentlyByCustomerID(String customerID);

}
