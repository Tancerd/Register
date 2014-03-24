package org.pwr.register.service;

import java.util.List;

import org.pwr.register.model.User;
import org.pwr.register.model.UserGame;

public interface UserGameService {
	public User getUserGameById(Integer id);
	public List getAllUsersGames();
	public boolean addUserGame(UserGame userGame);
}
