package org.pwr.register.controllers;

import java.util.List;

import org.pwr.register.model.User;
import org.pwr.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;

	@RequestMapping({"/", "/home"})
	public String homePage()
	{
		return "home";
	}
	
	@RequestMapping(value = "/test", produces = "application/json")
	public @ResponseBody User testPage()
	{
		return null;//((User)userService.getUserByLogin("test"));
	}
	
	@RequestMapping({"/test2"})
	public String testPage2()
	{
		String page = "";
		List<User> users = userService.getAllUsers();
		for (User u : users)
			page += u.getPassword() + " ";
		return page;
	}
}
