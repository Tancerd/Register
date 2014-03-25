package org.pwr.register.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pwr.register.model.UserGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserGameDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List getAllUsersGames() {
		Session session = sessionFactory.getCurrentSession();
		List users = session.createQuery("from UserGame").list();
		return users;
	}

	@Transactional
	public boolean save(UserGame userGame) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(userGame);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}
	
	@Transactional
	public UserGame getUserGameByID(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from user_game where id = :id ");
		query.setParameter("id", id);
		List list = query.list();
		return (UserGame)list.get(0);
	}

}
