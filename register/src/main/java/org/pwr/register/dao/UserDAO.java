package org.pwr.register.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pwr.register.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public boolean save(User user) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(user);
			return true;
		} catch (HibernateException e) {
			return false;
		} 
	}

	public void delete(User user) {

	}

	public void saveOrUpdate() {

	}

	@Transactional
	public List findAll() {
		Session session = sessionFactory.getCurrentSession();
		List users = session.createQuery("from User").list();
		return users;
	}

	@Transactional
	public User findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}
	
	@Transactional
	public User findByLogin(String login) {
		Session session = sessionFactory.getCurrentSession();
		List users = session.createQuery("from User where login = \'" + login + "\'").list();
		return (User)users.get(0);
	}

}