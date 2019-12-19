package com.project.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.UserDao;
import com.project.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addUser(User uObj) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(uObj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public User validateUser(String email, String pass) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session
					.createQuery("from com.project.model.User where User_Email=:email and User_Password=:password");

			query.setParameter("email", email);
			query.setParameter("password", pass);

			List<User> list = query.list();

			if (list.size() != 0) {
				return list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public User getSeller() {
		try {

			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from com.project.model.User where userRole='Seller'");

			List<User> list = query.list();

			if (list.size() != 0) {

				return list.get(0);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public User getBuyer(int id) {
		try {

			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from com.project.model.User where userRole='Buyer' and userId=" + id);

			List<User> list = query.list();

			if (list.size() != 0) {

				return list.get(0);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
