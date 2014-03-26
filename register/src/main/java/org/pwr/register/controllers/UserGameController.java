package org.pwr.register.controllers;

import org.pwr.register.model.UserGame;
import org.pwr.register.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserGameController {
	
	@Autowired
	private UserGameService userGameService;
	
	@RequestMapping(value = "/userGame/", method = RequestMethod.POST)
	public void createGameForUser(@RequestBody UserGame userGame) {
		userGameService.addUserGame(userGame);
	}
	
	@RequestMapping("/allGames/")
	public void getAllUsersGames() {
		userGameService.getAllUsersGames();
	}

	@RequestMapping(value = "/userGame/", method = RequestMethod.GET)
	public UserGame getUserGameById() {
		return userGameService.getUserGameById(0);
	}
}
