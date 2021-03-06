package org.pwr.register.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.pwr.register.model.User;
import org.pwr.register.model.UserGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserGameDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	UserDAO userDAO;
	
	@Transactional
	public List getAllUsersGames() {
		Session session = sessionFactory.getCurrentSession();
		List users = session.createQuery("from UserGame").list();
		return users;
	}
	
	@Transactional
	public List getAllDoneQuests() {
		Session session = sessionFactory.getCurrentSession();
		List doneQuests = session.createQuery("from DoneQuest").list();
		return doneQuests;
	}

	@Transactional
	public boolean save(UserGame userGame) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(userGame);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Transactional
	public UserGame getUserGameByID(String login) {
		User u = userDAO.findByLogin(login);
		if (u != null)
			return u.getUserGame();
		else return null;
	}

	@Transactional
	public boolean createNewGame(String login) {
		try {
			User u = userDAO.findByLogin(login);
			if (u.getUserGame() == null)
			{
				UserGame userGame = new UserGame();
				
				userGame.setPoints(0);
				userGame.setUser(u);
				Session session = sessionFactory.getCurrentSession();
				session.save(userGame);
				
				return true;
			}
			else return false;
		} catch (HibernateException e) {
			return false;
		}

	}

	@Transactional
	public void deleteGame(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user.getUserGame());
	}
}
