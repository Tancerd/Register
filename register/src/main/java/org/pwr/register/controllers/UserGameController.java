package org.pwr.register.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.pwr.register.dto.DoneQuestDTO;
import org.pwr.register.dto.UserGameDTO;
import org.pwr.register.mapper.DoneQuestsMapper;
import org.pwr.register.mapper.UserGameMapper;
import org.pwr.register.model.DoneQuest;
import org.pwr.register.service.DoneQuestService;
import org.pwr.register.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@Autowired
	private DoneQuestsMapper doneQuestsMapper;
	
	@Autowired
	private DoneQuestService doneQuestService;

	@RequestMapping(value = "/userGame/", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody UserGameDTO getUserGameByLogin() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		
		return gameUserMapper.map(userGameService.getUserGameByLogin(name));
	}
	
	@RequestMapping(value ="/doneQuest/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<DoneQuestDTO> createDoneQuest(@RequestBody DoneQuestDTO doneQuestDTO)
	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		DoneQuest doneQuest = doneQuestsMapper.map(doneQuestDTO, name);

		if (doneQuestService.createDoneQuest(doneQuest)) {
			return new ResponseEntity<DoneQuestDTO>(doneQuestDTO, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<DoneQuestDTO>(doneQuestDTO, HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value="/endGame/", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Object> endGameAndCountPoints()
	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();
		
		if (userGameService.countPoints(name))
		{
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Object>(null, HttpStatus.IM_USED);
		}
	}
	
	
}
