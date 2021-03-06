package org.pwr.register.controllers.admin;

import java.util.List;

import org.pwr.register.dto.DoneQuestDTO;
import org.pwr.register.mapper.DoneQuestsMapper;
import org.pwr.register.model.DoneQuest;
import org.pwr.register.service.DoneQuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/adminPanel")
public class AdminPanelDoneQuestController {

	@Autowired
	private DoneQuestService doneQuestService;

	@Autowired
	private DoneQuestsMapper doneQuestsMapper;

	@RequestMapping(value = "/allDoneQuests/", method = RequestMethod.GET)
	public @ResponseBody List getAllDoneQuests() {
		return doneQuestsMapper.map(doneQuestService.getAllDoneQuests());
	}

	@RequestMapping(value = "/doneQuest/{userName}", method = RequestMethod.DELETE)
	public ResponseEntity removeDoneQuest(@PathVariable String userName) {
		
		if (doneQuestService.removeQuests(userName)) {
			return new ResponseEntity<Object>(null, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}

}
