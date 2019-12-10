package com.project.test;

import static org.junit.Assert.assertTrue;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.project.config.DBConfig;
import com.project.model.User;
import com.project.service.UserService;

public class TestClass {

	private static UserService userService;
	
	@BeforeClass
	public static void init(){
		
	try {
	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	 	
		userService=context.getBean(UserService.class,"userService");
   	 	System.out.println("I m in init - end");
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
	
	@Test
	public void addUserTest(){
		User uObj=new User();
	
		uObj.setUserName("Karnika Agarwal");
		uObj.setUserEmail("karnikaa17@gmail.com");
		uObj.setUserAddress("Noida");
		uObj.setUserMobile(9560230212l);
		
		uObj.setUserPassword("kkk");
		
		boolean u=userService.addUser(uObj);
		assertTrue("Problem in Adding Buyer", u);
		
	}
}
