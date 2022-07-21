package com.fashionShop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fashionShop.entity.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, String>{
	
	@Query("select p from Product p where p.productID = 'PD001' ")
    List<Product> getProducts();
	
	@Query("select p from Product p where p.categoryID "
			+ "in(select c.categoryID from Categories c where c.categorytype = ?2) ")
	Page<Product> getProductsByCategory(Pageable pageable, String category);
	
	@Query("select p from Product p where p.categoryID "
			+ "in(select c.categoryID from Categories c where c.categorytype = ?1) ")
	List<Product> getProductsByCategory(String category);

//    List<Product> getProductsByCategory(String category);
}

//public interface ProductRepository extends JpaRepository<Product, String>{
//	
//	@Query("select p from Product p where p.productID = 'PD001' ")
//    List<Product> getProducts();
//	
//
//}
