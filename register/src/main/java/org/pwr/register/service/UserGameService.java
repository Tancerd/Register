package org.pwr.register.service;

import java.util.List;

import org.pwr.register.model.UserGame;

public interface UserGameService {
	public Integer getUserGameByLogin(String name);
	public List getAllUsersGames();
	public boolean addUserGame(UserGame userGame);
	public boolean createNewGame(Integer id);
}
