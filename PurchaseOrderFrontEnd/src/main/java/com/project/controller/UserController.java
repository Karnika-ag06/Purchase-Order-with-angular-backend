package com.project.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.dao.ProductDao;
import com.project.dao.PurchaseOrderDao;
import com.project.dao.UserDao;
import com.project.model.Products;
import com.project.model.PurchaseOrder;
import com.project.model.PurchaseOrderItems;
import com.project.model.User;
import com.project.service.UserService;

@Controller
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/user")
	public ResponseEntity<?> addUser(@RequestBody User uObj) {
		boolean b = userService.addUser(uObj);
		if (b) {
			return new ResponseEntity<String>("User Added Successfully..", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("problem  in Adding user..", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@Autowired
	HttpSession session;

	@ResponseBody
	@RequestMapping(value = "/userValidate", method = RequestMethod.POST)
	public ResponseEntity<?> validateUser(@RequestParam(name = "userEmail") String userEmail,
			@RequestParam(name = "userPass") String userPass, ModelMap map) {
		System.out.println("hi");
		User u = userService.validateUser(userEmail, userPass);

		if (u != null) {

			session.setAttribute("userObj", u);

			return new ResponseEntity<User>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Not found", HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@Autowired
	ProductDao productDao;

	@GetMapping(value = "/viewAllProducts")
	public ResponseEntity<?> viewAllProducts() {
		List<Products> list = productDao.viewAllProducts();
		if (list.size() != 0) {
			return new ResponseEntity<List<Products>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("list empty", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Autowired
	UserDao userDao;

	@Autowired
	PurchaseOrderDao poDao;

	@PostMapping(value = "/purchaseOrder/{buyerId}")
	public ResponseEntity<?> raisePurchaseOrder(@PathVariable int buyerId,
			@RequestBody List<PurchaseOrderItems> purchaseOrderItemsList) {

		System.out.println("Buyer Id : " + buyerId);

		for (PurchaseOrderItems obj : purchaseOrderItemsList) {
			System.out.println(obj);
		}

		PurchaseOrder poObj = new PurchaseOrder();
		poObj.setUserObj(userDao.getBuyer(buyerId));
		poObj.setSellerObj(userDao.getSeller());
		poObj.setStatus("Sent to Seller");
        poObj.setCreatedDate(LocalDate.now());
		for (PurchaseOrderItems obj : purchaseOrderItemsList) {

			obj.setProductObj(productDao.getProductById(obj.getProductId()));
			obj.setPurchaseOrderObj(poObj);
		}

		poObj.setPurchaseOrderItemsObj(purchaseOrderItemsList);

		poDao.addPurchaseOrder(poObj);

		if (poObj != null) {
			return new ResponseEntity<PurchaseOrder>(poObj, HttpStatus.OK);
		} else

			return new ResponseEntity<String>("Problem in raising request", HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
