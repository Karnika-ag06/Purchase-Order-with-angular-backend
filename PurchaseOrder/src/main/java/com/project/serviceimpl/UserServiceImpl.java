package com.project.serviceimpl;

import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.UserDao;
import com.project.model.User;
import com.project.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserDao userDao;
	
	public boolean addUser(User uObj) {
		
		
		uObj.setCreatedDate(LocalDate.now());
		uObj.setCreatedBy("System");
		uObj.setUserIsActive("Y");
		uObj.setUserRole("Buyer");
		return userDao.addUser(uObj);
		}
	
	public User validateUser(String email,String pass) {
	
	return userDao.validateUser(email,pass);
}
}
