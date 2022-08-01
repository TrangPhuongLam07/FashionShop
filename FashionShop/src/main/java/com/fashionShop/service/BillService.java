package com.fashionShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionShop.dto.BillDTO;
import com.fashionShop.dto.ShowCartItemDTO;
import com.fashionShop.entity.Bill;
import com.fashionShop.entity.BillDetail;
import com.fashionShop.entity.Customer;
import com.fashionShop.entity.Product;
import com.fashionShop.repository.BillDetailRepository;
import com.fashionShop.repository.BillRepository;

@Service
public class BillService {
	private final BillRepository billRepo;
	private final BillDetailRepository billDetailRepo;
	
	
	@Autowired
	public BillService(BillRepository billRepo, BillDetailRepository billDetailRepo) {
		super();
		this.billRepo = billRepo;
		this.billDetailRepo = billDetailRepo;
	}



	public void saveBill(BillDTO billDTO, String customerID) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setCustomerID(customerID);
		//get count buy recently
		int countBuy = billRepo.getCountBuyRecentlyByCustomerID(customerID);
		
		Bill bill = new Bill();
		bill.setRecipientName(billDTO.getRecipientName());
		bill.setPhone(billDTO.getPhone());
		bill.setAddress(billDTO.getAddress());
		bill.setNotes(billDTO.getNotes());
		bill.setPaymentID(billDTO.getPaymentID());
		bill.setCustomerID(customer);
		bill.setDateCreate(billDTO.getDateCreate());
		bill.setTotal(billDTO.getTotal());
		bill.setCountBuy(countBuy + 1);
		
		billRepo.save(bill);
	}



	public String getBillIDByCustomerID(String customerID) {
		// TODO Auto-generated method stub
		
		return billRepo.getBillIDByCustomerID(customerID);
	}



	public void saveBillDetail(List<ShowCartItemDTO> listShowCartItem, String billID) {
		// TODO Auto-generated method stub
		
		for (ShowCartItemDTO showCartItemDTO : listShowCartItem) {
			//create bill, product object to save
			BillDetail billDetail = new BillDetail();
			Bill bill = new Bill();
			bill.setBillID(billID);
			Product product = new Product();
			product.setProductID(showCartItemDTO.getProductID());
			
			//save attributes of bill detail
			billDetail.setBillID(bill);
			billDetail.setProductID(product);
			billDetail.setQuantity(showCartItemDTO.getQuantity());
			billDetailRepo.save(billDetail);
		}
		
		
	}

}
