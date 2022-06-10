package com.fashionShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashionShop.entity.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, String>{

}
