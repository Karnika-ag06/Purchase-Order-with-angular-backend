package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.VendorProductDao;
import com.project.model.User;
import com.project.model.VendorProduct;

@RestController
@CrossOrigin("http://localhost:4200")
public class VendorController {

	
	@Autowired 
	VendorProductDao vendorproductDao;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/updateProductQuantity",method=RequestMethod.GET)
	public ResponseEntity<?> addInVendorproductTable(@RequestParam(name="productId") int productId  , 
			@RequestParam(name="quantity") int quantity,@RequestParam(name="vendorId")int vendorId)
	{
		
	
		
		VendorProduct r=vendorproductDao.checkProductForVendor(vendorId, productId); 
		if(r!=null) {
			r.setQuantity(r.getQuantity()+quantity);
		}
		else {
			r = new VendorProduct();			
			r.setVendorId(vendorId);
			r.setProductId(productId);
			r.setQuantity(quantity);
	
		
		
		}
		
		boolean re=vendorproductDao.add(r);                    
		
		 if(re) {
			 	return new ResponseEntity<Object>(r,HttpStatus.OK);
		 }
		 else
		 
			 return new ResponseEntity<String>("Problem in adding quantity",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@GetMapping(value = "/viewAllAvailableProducts")
	public ResponseEntity<?> viewAllAvailableProducts(@RequestParam(name="vendorId") int vendorId) {
		
		  						    //fetch user's id through session 
		
		List<?> vendorProducts = vendorproductDao.getAllProducts(vendorId);      //view products added by vendor getallProducts method in VendorProductDao
				System.out.println(vendorProducts);
		return new ResponseEntity<List<?>>(vendorProducts,HttpStatus.OK);    											    //return view product

	}


}
