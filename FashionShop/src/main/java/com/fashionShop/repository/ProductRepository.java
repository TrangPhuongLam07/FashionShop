package com.fashionShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fashionShop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
	
	@Query("select p from Product p where p.productID = 'PD001' ")
    List<Product> getProducts();
	

}
