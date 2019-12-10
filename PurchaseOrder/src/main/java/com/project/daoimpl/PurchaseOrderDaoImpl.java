  
package com.project.daoimpl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.PurchaseOrderDao;
import com.project.model.PurchaseOrder;


@Transactional
@Repository("purchaseOrderDao")
public class PurchaseOrderDaoImpl implements PurchaseOrderDao {

	
	
		@Autowired
		SessionFactory sessionFactory;

		
		@Override
		public boolean addPurchaseOrder(PurchaseOrder pobj) {
			try {
				Session session=sessionFactory.getCurrentSession();
		
				session.saveOrUpdate(pobj);
				return true;

				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
	}


		@Override
		public List<PurchaseOrder> viewAllOrders() {
			try {
				Session session=sessionFactory.getCurrentSession();
				Query q=session.createQuery("from com.project.model.PurchaseOrder where status='Sent to Seller'");
		        return q.list();

				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
}