package com.project.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.PurchaseOrderItemsDao;

@Repository("pruchaseOrderItems")
@Transactional
public class PurchaseOrderItemsDaoImpl implements PurchaseOrderItemsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<PurchaseOrderItemsDao> getLineItemsById(int purchaseOrderId) {
try {
			
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createQuery("from com.project.model.PurchaseOrderItems where purchaseOrderId=:x");
			q.setParameter("x", purchaseOrderId);
			List<PurchaseOrderItemsDao> poiList = q.list();
			return poiList;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
