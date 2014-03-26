package org.pwr.register.service;

import java.util.List;

import org.pwr.register.dao.UserGameDAO;
import org.pwr.register.model.UserGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGameServiceImpl implements UserGameService{

	@Autowired
	private UserGameDAO userGameDAO;
	
	public UserGame getUserGameById(Integer id) {
		return userGameDAO.getUserGameByID(id);
	}

	public List getAllUsersGames() {
		return userGameDAO.getAllUsersGames();
	}

	public boolean addUserGame(UserGame userGame) {
		return userGameDAO.save(userGame);
	}

}
