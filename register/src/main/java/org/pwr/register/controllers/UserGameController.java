package org.pwr.register.controllers;

import org.pwr.register.mapper.GameUserMapper;
import org.pwr.register.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/commonGame")
public class UserGameController {

	@Autowired
	private GameUserMapper gameUserMapper;
	
	@Autowired
	private UserGameService userGameService;

	@RequestMapping(value = "/userGame/", method = RequestMethod.GET)
	public Integer getUserGameByLogin() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		
		return userGameService.getUserGameByLogin(name);
	}

}
