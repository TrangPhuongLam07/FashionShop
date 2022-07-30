package com.fashionShop.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fashionShop.dto.ShowCartItemDTO;
import com.fashionShop.entity.CartItem;
import com.fashionShop.entity.Customer;
import com.fashionShop.entity.Product;
import com.fashionShop.service.CustomerService;
import com.fashionShop.service.ProductService;
import com.fashionShop.service.ShoppingCartServices;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
	
	private final ShoppingCartServices cartServices;
	
	private final ProductService productService;
	
	
	
	
//	@GetMapping("/cart")
//	public String showShoppingCart(Model model, @AuthenticationPrincipal Authentication authentication ) {
//		Customer customer = customerService.getCurrentlyLoggedInCustomer(authentication);
//		List<CartItem> cartItems = cartServices.listCartItems(customer);
//		
//		model.addAttribute("cartItems", cartItems);
//		model.addAttribute("pageTitle", "Shopping Cart");
//		
//		return "/shoppingCart/shopping-cart";
//	}
	
	@Autowired
	public ShoppingCartController(ShoppingCartServices cartServices, ProductService productService) {
		super();
		this.cartServices = cartServices;
		this.productService = productService;
	}

	@GetMapping
	public String showShoppingCart(Model model, HttpSession session) {
		
		return showCartOfCustomer(model, null, session);
	}
	
//	@GetMapping("{customerID}")
	@RequestMapping(value = "{customerID}", method = RequestMethod.GET)
	public String showCartOfCustomer(Model model, @PathVariable("customerID") String customerID, 
			HttpSession session) {
		String username = "Alex Lam";
		
//		HttpSession session = servletRequest.getSession();
		session.setAttribute("username", customerID);
//		String customerid = (String) session.getAttribute(customerID);
		
		String shoppingCartID = cartServices.getShoppingCartID(customerID);
		List<CartItem> listCartItems = cartServices.listCartItems(shoppingCartID);
		List<Product> products = productService.listProductInCart(listCartItems);
		List<ShowCartItemDTO> listShowCartItemDTO = new ArrayList<ShowCartItemDTO>();
		
		for (int i = 0; i < products.size(); i++) {
			ShowCartItemDTO showItemDTO = new ShowCartItemDTO();
			Product product = products.get(i);
			CartItem cartItem = listCartItems.get(i);
			
			showItemDTO.setProductname(product.getProductname());
			showItemDTO.setImage(product.getImage());
			showItemDTO.setPrice(product.getPrice());
			showItemDTO.setQuantity(cartItem.getQuantity());
			showItemDTO.setProductID(product.getProductID());
			
			listShowCartItemDTO.add(showItemDTO);
		}
		
		model.addAttribute("listShowCartItem", listShowCartItemDTO);
		return "/shoppingCart/shopping-cart";
	}
	
	@RequestMapping("/delete/{productID}/{customerID}")
	public String deleteCart(@PathVariable("productID") String productID, 
			@PathVariable("customerID") String customerID) {
		
		cartServices.deleteCartItem(productID);
		return "redirect:/cart/" + customerID;
	}

	@RequestMapping("/add/{productID}/{quantity}/{customerID}")
	public String addCart(@PathVariable("productID") String productID, 
			@PathVariable("quantity") int quantity, @PathVariable("customerID") String customerID) {
		
		cartServices.save(quantity, productID, customerID);
		return "redirect:/" ;
	}
	
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String addCart() {
//		
////		CartItem cartItem = new CartItem(null, null, 0);
////		cartServices.save(cartItem);
//		return "redirect:/";
//	}

}
