package com.project.test;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.config.DBConfig;
import com.project.dao.PurchaseOrderDao;
import com.project.model.PurchaseOrder;


public class PurchaseOrderTest {

	@Autowired
private static PurchaseOrderDao purchaseorder;
	
	@BeforeClass
	public static void init() {

		try {
			System.out.println("i m in");
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);

			purchaseorder  = context.getBean(PurchaseOrderDao.class, "purchaseorder");

		}

		catch (Exception e) {

			e.printStackTrace();

		}

		System.out.println("I m Init.....");

	}

	/*@Test
	public void addPurchaseOrderTest()
	{
		PurchaseOrder uObj = new PurchaseOrder();
		uObj.set(102);
		//uObj.setPo_Id(10);
		uObj.setPoName("secondorder");
		uObj.setProductsId(101111);
		uObj.setQuantity(120);
		uObj.setCreatedDate(LocalDate.now());
		uObj.setStatus("pending");
		boolean b = purchaseorder.addPurchaseOrder(uObj);

		assertTrue("Problem in adding product", b);

	}*/

}