package org.pwr.register.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pwr.register.model.UserGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserGameDAO {

	@Autowired
	private static SessionFactory sessionFactory;

	@Transactional
	public static boolean save(UserGame userGame) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(userGame);
			return true;
		} catch (HibernateException e) {
			return false;
		} 
	}
	
}
