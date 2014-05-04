package org.pwr.register.service;

import java.util.List;

import org.pwr.register.model.UserGame;

public interface UserGameService {
	public UserGame getUserGameByLogin(String name);
	public List getAllUsersGames();
	public boolean addUserGame(UserGame userGame);
	public boolean createNewGame(String login);
	public void deleteGameByUserLogin(String login);
	public List getAllDoneQuests(String user);
	public boolean countPoints(String name);
}
