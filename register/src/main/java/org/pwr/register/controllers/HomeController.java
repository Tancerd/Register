package org.pwr.register.controllers;

import java.util.List;

import org.pwr.register.dto.UserDTO;
import org.pwr.register.dto.UserGameDTO;
import org.pwr.register.mapper.GameUserMapper;
import org.pwr.register.mapper.UserMapper;
import org.pwr.register.model.User;
import org.pwr.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GameUserMapper gameUserMapper;
	
	@Autowired
	private UserMapper userMapper;

	@RequestMapping({"/", "/home"})
	public String homePage()
	{
		return "home";
	}
	
	@RequestMapping(value = "/test/{login}", produces = "application/json")
	public @ResponseBody UserGameDTO testPage(@PathVariable String login)
	{
		if (userService.getUserByLogin(login) != null)
			return gameUserMapper.map(userService.getUserByLogin(login).getUserGame());
		else return null;
	}
	
	@RequestMapping(value = "/test2/{login}", produces = "application/json")
	public @ResponseBody UserDTO test2Page(@PathVariable String login)
	{
		if (userService.getUserByLogin(login) != null)
			return userMapper.map(userService.getUserByLogin(login));
		else return null;
	}
	
	@RequestMapping(value = "/test3/{id}", produces = "application/json")
	public @ResponseBody UserDTO testPage(@PathVariable Integer id)
	{
		if (userService.getUserById(id) != null)
			return userMapper.map(userService.getUserById(id));
		else return null;
	}
}
