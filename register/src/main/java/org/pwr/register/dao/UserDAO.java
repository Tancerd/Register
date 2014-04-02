package org.pwr.register.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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

	@Transactional
	public String delete(String userName) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query deleteQUery = session.createQuery("delete User where login = :login");
			deleteQUery.setParameter("login", userName);
			deleteQUery.executeUpdate();
			return "Success!";
		} catch (Exception e) {
			System.err.print(e);
			return "Hibernate... we have a problem";
		}
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
		List users = session.createQuery(
				"from User where login = \'" + login + "\'").list();
		if (users.size() != 0)
			return (User) users.get(0);
		else
			return null;
	}

}