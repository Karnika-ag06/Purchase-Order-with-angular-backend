package com.project.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.dao.ProductDao;
import com.project.dao.PurchaseOrderDao;
import com.project.dao.PurchaseOrderItemsDao;
import com.project.dao.UserDao;
import com.project.model.Products;
import com.project.model.PurchaseOrder;
import com.project.model.PurchaseOrderItems;
import com.project.model.User;

@Controller
public class POController {
	
	@Autowired
	PurchaseOrderDao purchaseOrderDao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CheckSession check;
	
	@Autowired
	PurchaseOrderItemsDao purchaseOrderItems;
	
	 @RequestMapping(value="/getRaisePOform",method=RequestMethod.GET)
	  public String get(ModelMap map)
     {
		
                     map.addAttribute("productDetails",productDao.viewAllProducts());
                    
                     return "RaisePo";
     }
	
	
	@RequestMapping(value="/raisePO",method=RequestMethod.POST)
	public String raisePurchaseOrder(@RequestBody List<PurchaseOrderItems> purchaseOrderItemsList, ModelMap map) {
		
		System.out.println("Inside Raise PO Call >>> ");
		
		User bObj=(User)session.getAttribute("uObj");
		
		PurchaseOrder po=new PurchaseOrder();
		po.setUserObj(bObj);
		
		System.out.println("Seller : "+userDao.getSeller());
		 po.setSellerObj(userDao.getSeller());
		 po.setCreatedDate(LocalDate.now());
		po.setStatus("sent to seller");
		for(PurchaseOrderItems obj:purchaseOrderItemsList) {
			obj.setProductObj(productDao.getProductById(obj.getProductId()));
			obj.setPurchaseOrderObj(po);
		}
		
		po.setPurchaseOrderItemsObj(purchaseOrderItemsList);
		
				
		System.out.println("Purchase Order : "+po);
		
		
		purchaseOrderDao.addPurchaseOrder(po);
		
		map.addAttribute("msg","Purchase Order has been raised succesfully...");
		return "success";
		}
	
	@RequestMapping(value="/getProductNameById",method=RequestMethod.GET)
	@ResponseBody
	 public Products getProductById(@RequestParam int productId)
    {
		
                   Products pObj=productDao.getProductById(productId);
                   
                    return pObj;
    }
	
	
	@RequestMapping(value="viewPOS",method=RequestMethod.GET)
	public String getAllUsers(ModelMap map,@RequestParam(required=false) String msg)
	{
		
		List<PurchaseOrder> list = purchaseOrderDao.viewAllOrders();
		map.addAttribute("list", list);
		System.out.println("list size : "+list.size());
		return "SellerViewPo";
		
	}
	
	
	
	
	@RequestMapping(value = "/viewLineItems", method = RequestMethod.GET)
	public String viewLineItems(@RequestParam int viewId,ModelMap map) {
		
		
		System.out.println(viewId);
		List<PurchaseOrderItems> poitemslist = purchaseOrderItems.getLineItemsById(viewId);
		map.addAttribute("poitemslist", poitemslist);
		System.out.println(poitemslist);
		session.setAttribute("poitemslist", poitemslist);
		return "SellerViewLineItems";
	}	
		
	
	}
