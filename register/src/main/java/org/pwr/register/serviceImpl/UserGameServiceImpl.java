package org.pwr.register.serviceImpl;

import java.util.List;

import org.pwr.register.dao.UserDAO;
import org.pwr.register.dao.UserGameDAO;
import org.pwr.register.model.DoneQuest;
import org.pwr.register.model.User;
import org.pwr.register.model.UserGame;
import org.pwr.register.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGameServiceImpl implements UserGameService {

	@Autowired
	private UserGameDAO userGameDAO;
	
	@Autowired
	private UserDAO userDAO;

	public UserGame getUserGameByLogin(String login) {
		return userGameDAO.getUserGameByID(login);
	}

	public List getAllUsersGames() {
		return userGameDAO.getAllUsersGames();
	}

	 
	public boolean addUserGame(UserGame userGame) {
		return userGameDAO.save(userGame);
	}

	public boolean createNewGame(String login) {
		return userGameDAO.createNewGame(login);
	}

	public void deleteGameByUserLogin(String login) {
		User user = userDAO.findByLogin(login);
		if (user != null) {
			userGameDAO.deleteGame(user);
		}
	}

	public List getAllDoneQuests(String login) {
		User user = userDAO.findByLogin(login);
		if (user != null) {
			return userGameDAO.getAllDoneQuests();
		}
		return null; 
	}

	@Override
	public boolean countPoints(String name) {
		UserGame userGame = userGameDAO.getUserGameByID(name);
		if (userGame.getPoints() > 0) return false;
		int result = 0;
		for (DoneQuest gQ : userGame.getDoneQuests())
		{
			result += gQ.getExtraPoints() + gQ.getQuest().getDefaultPoints();
			if (gQ.getDoneTime().after(gQ.getQuest().getDefaultTime()))
				result -= 1; //TODO:
		}
		userGame.setPoints(result);
		userGameDAO.save(userGame);
		return true;
		
	}
	
}
