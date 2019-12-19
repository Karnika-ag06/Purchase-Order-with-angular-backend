package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dao.PurchaseOrderDao;
import com.project.dao.PurchaseOrderItemsDao;
import com.project.model.PurchaseOrder;
import com.project.model.PurchaseOrderItems;

@Controller
@CrossOrigin("http://localhost:4200")
public class SellerController {

	@Autowired
	HttpSession session;

	@Autowired
	PurchaseOrderDao poObj;

	@RequestMapping(value = "/viewPoList", method = RequestMethod.GET)
	public ResponseEntity<?> viewPoList(ModelMap map) {

		List<PurchaseOrder> polist = poObj.viewAllOrders();
		map.addAttribute("polist", polist);
		session.setAttribute("polist", polist);
		return new ResponseEntity<List<PurchaseOrder>>(polist, HttpStatus.OK);
	}

	@Autowired
	PurchaseOrderItemsDao poitems;

	@GetMapping(value = "/viewLineItems")
	public ResponseEntity<?> viewLineItems(@RequestParam(name = "viewId") int viewId) {
		System.out.println(viewId);
		List<PurchaseOrderItems> poitemslist = poitems.getLineItemsById(viewId);
		// map.addAttribute("poitemslist", poitemslist);
		System.out.println(poitemslist);
		session.setAttribute("poitemslist", poitemslist);
		return new ResponseEntity<List<PurchaseOrderItems>>(poitemslist, HttpStatus.OK);
	}
}
