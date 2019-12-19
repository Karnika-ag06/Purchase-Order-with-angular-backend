package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.ProductDao;
import com.project.dao.VendorProductDao;
import com.project.model.Products;
import com.project.model.User;
import com.project.model.VendorProduct;

@Controller
public class VendorProductController {

	@Autowired
	VendorProductDao vendorDaoObj;

	@Autowired
	HttpSession session;

	@Autowired
	ProductDao productDaoObj;

	@RequestMapping(value = "/viewAllAvailableProducts", method = RequestMethod.GET)
	public String viewAllAvailableProducts(ModelMap map) {

		User userObj = (User) session.getAttribute("uObj");
		int vendorId = userObj.getUserId();

		map.addAttribute("productDetails", vendorDaoObj.getAllProducts(vendorId));

		return "ViewProduct";

	}

	@RequestMapping(value = "/viewAllProducts", method = RequestMethod.GET)
	public String viewAllProducts(ModelMap map) {

		map.addAttribute("productDetails", productDaoObj.viewAllProducts());

		return "ViewAllProducts";
	}

	@RequestMapping(value = "/updateProductQuantity", method = RequestMethod.GET)
	public String getUpdateQuantityForm(ModelMap map) {

		map.addAttribute("productDetails", productDaoObj.viewAllProducts());
		return "AddQuantity";
	}

	@RequestMapping(value = "/updateProductQuantity", method = RequestMethod.POST)
	public ModelAndView addInVendorproductTable(@RequestParam int pId, @RequestParam int quantity) {

		User userObj = (User) session.getAttribute("uObj");

		VendorProduct r = vendorDaoObj.checkProductForVendor(userObj.getUserId(), pId);
		if (r != null) {
			r.setQuantity(r.getQuantity() + quantity);
		} else {
			r = new VendorProduct();
			r.setVendorId(userObj.getUserId());
			r.setProductId(pId);
			r.setQuantity(quantity);
		}

		vendorDaoObj.add(r);

		ModelAndView mv = new ModelAndView("VendorPage");
		mv.addObject("msg", "Product Quantity Added Succesfully");
		return mv;
	}

}