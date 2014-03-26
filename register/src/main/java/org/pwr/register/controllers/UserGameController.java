package org.pwr.register.controllers;

import java.util.List;

import org.pwr.register.mapper.GameUserMapper;
import org.pwr.register.model.UserGame;
import org.pwr.register.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserGameController {

	@Autowired
	private GameUserMapper gameUserMapper;
	
	@Autowired
	private UserGameService userGameService;

	@RequestMapping(value = "/userGame/", method = RequestMethod.POST)
	public boolean createGameForUser(@RequestBody UserGame userGame) {
		return userGameService.addUserGame(userGame);
	}

	@RequestMapping("/allGames/")
	public List getAllUsersGames() {
		return gameUserMapper.mapList(userGameService.getAllUsersGames()); 
	}

	@RequestMapping(value = "/userGame/", method = RequestMethod.GET)
	public Integer getUserGameByLogin() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		
		return userGameService.getUserGameByLogin(name);
	}

	@RequestMapping(value = "/newGame/{id}", method = RequestMethod.POST)
	public boolean createNewGame(@PathVariable Integer id) {
		return userGameService.createNewGame(id);
	}

}
