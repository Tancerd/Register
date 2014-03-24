package org.pwr.register.controllers;

import org.pwr.register.model.UserGame;
import org.pwr.register.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserGameController {
	
	@Autowired
	UserGameService userGameService;
	
	@RequestMapping("/createGame/{id}")
	public void createGameForUser(@RequestBody UserGame userGame) {
		userGameService.addUserGame(userGame);
	}
	
}
