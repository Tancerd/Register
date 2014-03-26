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
	public Integer getUserGameByID(String login) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select id from user where login = :login ");
		query.setParameter("login", login);
		Integer id = (Integer) query.uniqueResult();
		query = session.createQuery("select points from user_game where id = :id ");
		query.setParameter("id", id.toString());
		return (Integer) query.uniqueResult();
	}

	@Transactional
	public boolean createNewGame(Integer id) {
		try {
			UserGame userGame = new UserGame();
			userGame.setId(id);
			Session session = sessionFactory.getCurrentSession();
			session.save(userGame);
			return true;
		} catch (HibernateException e) {
			return false;
		}

	}
}
