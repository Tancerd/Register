package org.pwr.register.service;

import java.util.List;

import org.pwr.register.dao.UserDAO;
import org.pwr.register.dao.UserGameDAO;
import org.pwr.register.model.User;
import org.pwr.register.model.UserGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGameServiceImpl implements UserGameService {

	@Autowired
	private UserGameDAO userGameDAO;

	
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserGame getUserGameByLogin(String login) {
		return userGameDAO.getUserGameByID(login);
	}

	@Override
	public List getAllUsersGames() {
		return userGameDAO.getAllUsersGames();
	}

	@Override
	public boolean addUserGame(UserGame userGame) {
		return userGameDAO.save(userGame);
	}

	@Override
	public boolean createNewGame(String login) {
		return userGameDAO.createNewGame(login);
	}

	@Override
	public void deleteGameByUserLogin(String login) {
		User user = userDAO.findByLogin(login);
		if (user != null) {
			userGameDAO.deleteGame(user);
		}
	}

	@Override
	public List getAllDoneQuests(String login) {
		User user = userDAO.findByLogin(login);
		if (user != null) {
			return userGameDAO.getAllDoneQuests();
		}
		return null; 
	}
	
}
