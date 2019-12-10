package com.project.service;

import com.project.model.User;

public interface UserService {

	public boolean addUser(User uObj);
	public User validateUser(String email,String pass);
}
