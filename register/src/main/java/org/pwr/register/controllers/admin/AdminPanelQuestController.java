package org.pwr.register.controllers.admin;

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
public class AdminPanelQuestController {

	@Autowired
	private QuestService questService;

	@Autowired
	private QuestMapper questMapper;

	@RequestMapping(value = "/allQuests/", method = RequestMethod.GET)
	public @ResponseBody List getAllQuests() {
		return questService.getAllQuests();
	}

}
