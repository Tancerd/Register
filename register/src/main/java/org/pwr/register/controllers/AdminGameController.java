package org.pwr.register.controllers;

import java.util.List;

import org.pwr.register.dto.UserDTO;
import org.pwr.register.mapper.GameUserMapper;
import org.pwr.register.model.UserGame;
import org.pwr.register.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/adminGame")
public class AdminGameController {

	@Autowired
	private GameUserMapper gameUserMapper;
	
	@Autowired
	private UserGameService userGameService;

	/*
	@RequestMapping(value = "/userGame/", method = RequestMethod.POST)
	public boolean createGameForUser(@RequestBody UserGame userGame) {
		return userGameService.addUserGame(userGame);
	}
	*/
	@RequestMapping("/allGames/")
	public @ResponseBody List getAllUsersGames() {
		return gameUserMapper.mapList(userGameService.getAllUsersGames());
	}

	/*
	@RequestMapping(value = "/userGame/", method = RequestMethod.GET)
	public UserGameDTO getUserGameByLogin() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		
		return userGameService.getUserGameByLogin(name);
	}
	*/

	@RequestMapping(value = "/newGame/{login}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ResponseEntity<Object> createNewGame(@PathVariable String login) {
		if (userGameService.createNewGame(login))
		{
			return new ResponseEntity<Object>(null, HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}
}
