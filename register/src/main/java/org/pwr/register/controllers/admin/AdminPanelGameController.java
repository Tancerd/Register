package org.pwr.register.controllers.admin;

import java.util.List;

import org.pwr.register.mapper.UserGameMapper;
import org.pwr.register.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * All Games, Delete Game by user login, create game for user by his login, 
 */
@Controller
@RequestMapping("/adminPanel")
public class AdminPanelGameController {

	@Autowired
	private UserGameMapper gameUserMapper;

	@Autowired
	private UserGameService userGameService;

	@RequestMapping("/allGames/")
	public @ResponseBody
	List getAllUsersGames() {
		return gameUserMapper.mapList(userGameService.getAllUsersGames());
	}

	@RequestMapping(value = "/deleteGame/{userName}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<String> deleteGame(@PathVariable String userName) {
		userGameService.deleteGameByUserLogin(userName);
		return new ResponseEntity<String>(userName, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/newGame/{login}", method = RequestMethod.POST)
	public ResponseEntity<Object> createNewGame(@PathVariable String login) {
		if (userGameService.createNewGame(login)) {
			return new ResponseEntity<Object>(null, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}

}
