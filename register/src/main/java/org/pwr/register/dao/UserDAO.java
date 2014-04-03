package org.pwr.register.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pwr.register.dto.UserDTO;
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
	public boolean delete(User user) {
		try {
			Session session = sessionFactory.getCurrentSession();
			if (!user.getRole().equals("ROLE_ADMIN")) {
				session.delete(user);
			} else
				return false;
			return true;
		} catch (Exception e) {
			System.err.print(e);
			return false;
		}
	}

	@Transactional
	public boolean saveOrUpdate(User user, UserDTO userData) {
		Session session = sessionFactory.getCurrentSession();
		try {
			if (!userData.getLogin().equals("")) {
				user.setLogin(userData.getLogin());
			}
			if (!userData.getPassword().equals("")) {
				user.setPassword(userData.getPassword());
			}
			/*if (`!userData.getEmail().equals("")) {
				user.setEmail(userData.getEmail());)
			user.setEmail(userData.getEmail());*/
			session.update(user);
			return true;
		} catch (Exception ex) {
			System.out.print(ex);
			return false;
		}
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