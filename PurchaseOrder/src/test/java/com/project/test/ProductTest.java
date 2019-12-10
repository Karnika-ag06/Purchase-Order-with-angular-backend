package com.project.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.config.DBConfig;
import com.project.dao.ProductDao;
import com.project.model.Products;


public class ProductTest {
	private static ProductDao productDaoObj;

	@BeforeClass
	public static void init(){
		System.out.println("I m in init - start");
		//Created the object of Spring container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	
   	 	productDaoObj=context.getBean(ProductDao.class,"productDao");
   	 	System.out.println("I m in init - end");
	}
	
	@Test
	@Ignore
	public void addProductTest(){
		Products p=new Products();
		p.setProductName("Realme X2 Pro");
		p.setProductDesc("Realme Flagship phones");
		p.setProductPrice(30000);		
	
		boolean r=productDaoObj.addProduct(p);
		assertTrue("Problem in Adding User", r);
	}
	
	@Test
	@Ignore
	public void getProductByNameTest(){
		Products productObj=productDaoObj.getProductByName("Realme X2 Pro");
		assertNotSame("Product with given id doesnt exist", productObj);
	}
	
	
	@Test
	@Ignore
	public void getAllProductsTest(){
		List<Products> uList=productDaoObj.viewAllProducts();
		assertNotSame("Not Users Found...", uList.size(), 0);
	}
	
	@Test
	@Ignore
	public void deleteProducts(){
		boolean uObj=productDaoObj.deleteProduct(productDaoObj.getProductByName("Realme X2 Pro"));
		assertNotNull("User with given id doesnt exist", uObj);
	}
}