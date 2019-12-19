package com.project.dao;

import java.util.List;

import com.project.model.PurchaseOrderItems;

public interface PurchaseOrderItemsDao {
	public List<PurchaseOrderItems> getLineItemsById(int purchaseOrderId);
}