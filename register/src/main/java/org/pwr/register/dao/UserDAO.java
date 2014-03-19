package org.pwr.register.dao;

import java.util.List;

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
	
	public void save(User user) {

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
		User user = (User)session.get(User.class, id);
		return user;
	}
	
	
}