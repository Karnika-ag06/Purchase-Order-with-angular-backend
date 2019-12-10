package com.project.dao;

import java.util.List;

import com.project.model.PurchaseOrder;

public interface PurchaseOrderDao {
	
	public boolean addPurchaseOrder(PurchaseOrder pobj);
	public List<PurchaseOrder> viewAllOrders();

}