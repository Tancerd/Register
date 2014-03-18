package org.pwr.register.controllers;

import java.util.List;

import org.pwr.register.model.User;
import org.pwr.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;

	@RequestMapping({"/", "/home"})
	public String homePage()
	{
		return "home";
	}
	
	@RequestMapping({"/test"})
	public String testPage()
	{
		String page = "";
		page += ((User)userService.getUserByLogin("test")).getId();
		return page;
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
