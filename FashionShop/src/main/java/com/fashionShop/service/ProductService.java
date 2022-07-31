package com.fashionShop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fashionShop.entity.CartItem;
import com.fashionShop.entity.Product;
import com.fashionShop.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private  ProductRepository productRepo;
	
	
//	public ProductService(ProductRepository productRepo) {
//		super();
//		this.productRepo = productRepo;
//	}


	public Object getProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	public Page<Product> listAll(int pageNumber){
		Pageable pageable = PageRequest.of(pageNumber - 1, 12);
		return productRepo.findAll(pageable);
	}
	
	public Page<Product> listAll(int pageNumber, String category){
		Pageable pageable = PageRequest.of(pageNumber - 1, 10);
		return productRepo.getProductsByCategory(pageable, category);
	}
		
	public Iterable<Product> findAll(){
		return productRepo.findAll();
	}
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepo.findAll();
	}

//	public List<Product> findProductsWithSorting(String field){
//		return productRepo.findAll(Sort.by(Sort.Direction.ASC, field));
//	}
	
	public Page<Product> findPaginated(int pageNO, int pageSize){
		Pageable pageable = PageRequest.of(pageNO - 1, pageSize);
		return this.productRepo.findAll(pageable);
				
	}

	public List<Product> listProductInCart(List<CartItem> listCartItems) {
		List<Product> products = new ArrayList<Product>();
		for (CartItem cartItem : listCartItems) {
			
			products.add(productRepo.findByProductID(cartItem.getProduct().getProductID()));
		}
		
		return products;
	}

	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> listProduct = (List<Product>) productRepo.findAll();
		return listProduct;
	}

	public Product getProductByID(String productID) {
		// TODO Auto-generated method stub
		
		return productRepo.findByProductID(productID);
	}
}
