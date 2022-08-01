package com.fashionShop.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fashionShop.dto.BillDTO;
import com.fashionShop.dto.ShowCartItemDTO;
import com.fashionShop.entity.CartItem;
import com.fashionShop.entity.Customer;
import com.fashionShop.entity.Product;
import com.fashionShop.service.BillService;
import com.fashionShop.service.ProductService;
import com.fashionShop.service.ShoppingCartServices;

@Controller
public class PaymentController {
	private final ShoppingCartServices cartServices;
	private final ProductService productService;
	private final BillService billService;

	@Autowired
	public PaymentController(ShoppingCartServices cartServices, ProductService productService
			, BillService billService) {
		super();
		this.cartServices = cartServices;
		this.productService = productService;
		this.billService = billService;
	}
	
	
	@RequestMapping("/payment")
	public String payment() {
//		String customerID = (String) session.getAttribute("customerID");
//		List<ShowCartItemDTO> listShowCartItemDTO = getListShowCartItemDTO(customerID);
		
//		long totalCartItem= (long) session.getAttribute("totalCartItem");
//		int totalItemCart= (int) session.getAttribute("totalItemCart");
		
//		model.addAttribute("listShowCartItem", listShowCartItemDTO);
//		model.addAttribute("totalCart", totalCartItem);
//		model.addAttribute("totalItemCart", totalItemCart);
		return "/payment/payment";
	}
	
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public String process_payment(@RequestParam("name") String name, 
			@RequestParam("address") String address,
			@RequestParam("phone") String phone, 
			@RequestParam("notes") String notes, HttpSession session) {
		System.out.println("name: " + name);
		System.out.println("address: " + address);
		System.out.println("phone: " + phone);
		System.out.println("notes: " + notes);
		String customerID = (String) session.getAttribute("customerID");
		long totalCart = (long) session.getAttribute("totalCart");
		List<ShowCartItemDTO> listShowCartItem = (List<ShowCartItemDTO>) session.getAttribute("listShowCartItem");
		
//		Date ceateDate = D
		//save bill
		BillDTO billDTO = new BillDTO(name, phone, address, notes, null, null, totalCart);
		billService.saveBill(billDTO, customerID);
		System.out.println("1...........");
		//get bill id
		String billID = billService.getBillIDByCustomerID(customerID);
		System.out.println("2...........");
		//save bill detail
		billService.saveBillDetail(listShowCartItem, billID);
		System.out.println("3...........");
		//set buying = paid in shopping cart and create new shopping cart for customer id
		cartServices.paidBill(customerID);
		System.out.println("4...........");
		//send email bill
		return "redirect:/paymentSuccess";
	}
	
	@RequestMapping("/paymentSuccess")
	public String success_payment() {
		
		return "redirect:/";
	}
	
}
