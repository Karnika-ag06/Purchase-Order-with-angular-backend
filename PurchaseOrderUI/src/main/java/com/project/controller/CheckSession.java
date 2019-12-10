package com.project.controller;



import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckSession {
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpSession session;
	
	boolean checkSession(){
		
		Object obj=session.getAttribute("userObj");
		if(obj==null) {
			return false;
		}
		else {
			return true;
		}
		
	}
}