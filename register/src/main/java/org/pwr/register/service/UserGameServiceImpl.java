package org.pwr.register.service;

import java.util.List;

import org.pwr.register.dao.UserGameDAO;
import org.pwr.register.model.User;
import org.pwr.register.model.UserGame;

public class UserGameServiceImpl implements UserGameService{

	public User getUserGameById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getAllUsersGames() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addUserGame(UserGame userGame) {
		return UserGameDAO.save(userGame);
	}

}
