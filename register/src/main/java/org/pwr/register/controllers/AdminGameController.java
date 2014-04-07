package org.pwr.register.controllers;

import java.util.List;

import org.pwr.register.dto.UserDTO;
import org.pwr.register.mapper.DoneQuestsMapper;
import org.pwr.register.mapper.UserGameMapper;
import org.pwr.register.mapper.QuestMapper;
import org.pwr.register.mapper.UserMapper;
import org.pwr.register.model.DoneQuest;
import org.pwr.register.model.Quest;
import org.pwr.register.service.DoneQuestService;
import org.pwr.register.service.QuestService;
import org.pwr.register.service.UserGameService;
import org.pwr.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/adminPanel")
public class AdminGameController {

	@Autowired
	private UserGameMapper gameUserMapper;

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserGameService userGameService;

	@Autowired
	private QuestService questService;
	
	@Autowired
	private QuestMapper questMapper;
	
	@Autowired
	private DoneQuestService doneQuestService;
	
	@Autowired
	private DoneQuestsMapper doneQuestsMapper;
	
	/*
	 * @RequestMapping(value = "/userGame/", method = RequestMethod.POST) public
	 * boolean createGameForUser(@RequestBody UserGame userGame) { return
	 * userGameService.addUserGame(userGame); }
	 */
	@RequestMapping("/allGames/")
	public @ResponseBody
	List getAllUsersGames() {
		return gameUserMapper.mapList(userGameService.getAllUsersGames());
	}

	// zwracac tak jak poniżej
	@RequestMapping(value = "/deleteGame/{userName}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<String> deleteGame(@PathVariable String userName) {
		userGameService.deleteGameByUserLogin(userName);
		return new ResponseEntity<String>(userName, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/deleteUser/{userName}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<String> deleteUser(@PathVariable String userName) {
		if (userService.removeUser(userName)) {
			return new ResponseEntity<String>(userName, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>(userName,
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@RequestMapping(value = "/updateUser/{login}", method = RequestMethod.PUT, consumes = "application/json")
	public
	ResponseEntity<UserDTO> updateUser(@PathVariable String login, @RequestBody UserDTO user) {
		if (userService.updateUser(user, login)) {
			return new ResponseEntity<UserDTO>(user, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<UserDTO>(user,
					HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDTO> registerPOST(@RequestBody UserDTO userDTO) {
		if (userService.getUserByLogin(userDTO.getLogin()) == null
				&& userService.registerUser(userMapper.map(userDTO))) {
			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<UserDTO>((UserDTO) null,
					HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/allUsers/")
	public @ResponseBody
	List<UserDTO> getAllUsers() {
		return userMapper.listMap(userService.getAllUsers());
	}

	/*
	 * @RequestMapping(value = "/userGame/", method = RequestMethod.GET) public
	 * UserGameDTO getUserGameByLogin() { Authentication auth =
	 * SecurityContextHolder.getContext() .getAuthentication(); String name =
	 * auth.getName();
	 * 
	 * return userGameService.getUserGameByLogin(name); }
	 */

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void register() {

	}

	@RequestMapping(value = "/newGame/{login}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public ResponseEntity<Object> createNewGame(@PathVariable String login) {
		if (userGameService.createNewGame(login)) {
			return new ResponseEntity<Object>(null, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value = "/allDoneQuests/", method = RequestMethod.GET)
	public List getAllDoneQuests() {
		return doneQuestsMapper.listDoneDTOMap(doneQuestService.getAllQuests());
	}
	
	@RequestMapping(value = "/deleteDoneQuest/{userName}",method =  RequestMethod.GET)
	public boolean removeDoneQuest(@PathVariable String userName) {
		return doneQuestService.removeQuest(userName);
	}

	@RequestMapping(value = "/allQuests/",method =  RequestMethod.GET)
	public List getAllQuests() {
		return questService.getAllQuests();
	}
	
	@RequestMapping(value = "/allUserDoneQuest/{user}", method = RequestMethod.GET)
	public List getAllDoneQuest(@PathVariable String user) {
		return userGameService.getAllDoneQuests(user); 
	}
	
}
