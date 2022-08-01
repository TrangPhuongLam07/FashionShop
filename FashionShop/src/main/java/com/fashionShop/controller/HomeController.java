package com.fashionShop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fashionShop.dto.ShowCartItemDTO;
import com.fashionShop.entity.Account;
import com.fashionShop.entity.CartItem;
import com.fashionShop.entity.Product;
import com.fashionShop.service.ProductService;
import com.fashionShop.service.ShoppingCartServices;

@Controller
//@RequestMapping("/Home")
public class HomeController {
	
	private final ProductService productService;
	private final ShoppingCartServices cartServices;
	
	
	@Autowired
	public HomeController(ProductService productService, ShoppingCartServices cartServices) {
		super();
		this.productService = productService;
		this.cartServices = cartServices;
	}

	@RequestMapping("/")
	public String viewHomePage(Model model, HttpSession session) {
		
		return listByPage(model, 1, session);
	}
	
	@RequestMapping("/products")
	public ResponseEntity<Iterable<Product>> findAll(){
		return new ResponseEntity<Iterable<Product>>(productService.findAll(), HttpStatus.OK);
	}
	
//	@GetMapping(path = "{pageNumber}")
	@RequestMapping(value= "{pageNumber}", method = RequestMethod.GET)
	public String listByPage(Model model, 
			@PathVariable("pageNumber") int currentPage,
			HttpSession session) {
		System.out.println("current page......"+currentPage);
		
		Page<Product> page = productService.listAll(currentPage);
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		
		List<Product> listProducts = page.getContent();
		
		String customerID = (String) session.getAttribute("customerID");
		List<ShowCartItemDTO> listShowCartItemDTO = getListShowCartItemDTO(customerID);
			
			
			long totalCartItem = totalPriceCart(listShowCartItemDTO);
			int totalItemCart = totalItemCart(listShowCartItemDTO);
			session.setAttribute("listShowCartItem", listShowCartItemDTO);
			session.setAttribute("totalCart", totalCartItem);
			session.setAttribute("totalItemCart", totalItemCart);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("listProducts", listProducts);
		return "/home/index";
	}
	
	
	
	
//	@RequestMapping("/home")
//	public ModelAndView getProducts() {
//		ModelAndView mv = new ModelAndView("/home/index");
//		mv.addObject("list", productService.getProduct());
//		return mv;
//	}
	
//	@GetMapping("/home")
//	public String viewHomePage(Model model) {
//		return findPaginated(1, model);
//	}
	
	@RequestMapping("/blog")
	public String blog() {
		return "/blog/blog";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "/contact/contact";
	}
	
	@RequestMapping("/saleOff")
	public String saleOff() {
		return "/saleOff/sale-off";
	}
	
	
	
	@RequestMapping("/detailProduct")
	public String detailProduct(Model model, Product product) {
		model.addAttribute("product", product);
//		model.addAttribute("quantity", quantity);
//		model.addAttribute("productname", product.getProductname());
//		model.addAttribute("productID", product.getProductID());
//		model.addAttribute("price", product.getPrice());
//		model.addAttribute("image", product.getImage());
		return "/product/detail-product";
		
	}
	
	@RequestMapping("/detailProduct/{productID}")
	public String showDetailProduct(Model model, @PathVariable("productID") String productID, 
			HttpSession session) {
		Product product = productService.getProductByID(productID);
		System.out.println("productID: " + productID);
		System.out.println("product name: " + product.getProductname());
//		System.out.println("quantity: " + quantity);
		
		return	detailProduct(model, product);
		
//		return "redirect:/detailProduct";
		
	}
	
	public List<ShowCartItemDTO> getListShowCartItemDTO(String customerID){
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
		
		return listShowCartItemDTO;
		
	}
	public long totalPriceCart(List<ShowCartItemDTO> listShowCartItemDTO) {
		long total = 0;
		for (ShowCartItemDTO showCartItemDTO : listShowCartItemDTO) {
			total += showCartItemDTO.getPrice()*showCartItemDTO.getQuantity();
		}
		return total;
	}
	
	public int totalItemCart(List<ShowCartItemDTO> listShowCartItemDTO) {
		int total = listShowCartItemDTO.size();
		
		return total;
	}	
	
	
//	@GetMapping("/page/{pageNO}")
//	public String findPaginated (@PathVariable(value = "pageNO") int pageNO, Model model) {
//		int pageSize = 5;
//		
//		Page<Product> page = productService.findPaginated(pageNO, pageSize);
//		List<Product> listProduct = page.getContent();
//		
//		model.addAttribute("currentPage", pageNO);
//		model.addAttribute("totalPages", page.getTotalPages());
//		model.addAttribute("toatlItems", page.getTotalElements());
//		model.addAttribute("listProduct", listProduct);
//		
//		return "/home/index";
//	}
	
	
}
