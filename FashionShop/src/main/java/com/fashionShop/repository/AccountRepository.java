package com.fashionShop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fashionShop.entity.Account;
import com.fashionShop.entity.Product;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{
	@Query("select a from Account a where a.accountname = 'admin'" )
    Optional<Account> findStudentByName(String name);
	
//	@Query("select a from Product p where p.productID = 'PD001' ")
//    List<Product> getProducts();
	
}
