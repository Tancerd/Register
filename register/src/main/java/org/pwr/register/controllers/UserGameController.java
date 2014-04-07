package org.pwr.register.controllers;

import org.pwr.register.dto.UserGameDTO;
import org.pwr.register.mapper.UserGameMapper;
import org.pwr.register.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/commonPanel")
public class UserGameController {

	@Autowired
	private UserGameMapper gameUserMapper;
	
	@Autowired
	private UserGameService userGameService;

	@RequestMapping(value = "/userGame/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody UserGameDTO getUserGameByLogin() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		
		return gameUserMapper.map(userGameService.getUserGameByLogin(name));
	}

}
