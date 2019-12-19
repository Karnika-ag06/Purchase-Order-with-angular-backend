package com.project.dao;

import com.project.model.User;

public interface UserDao {

	public boolean addUser(User uObj);

	public User validateUser(String email, String pass);

	public User getSeller();

	public User getBuyer(int id);
}
