package org.pwr.register.controllers;

import org.pwr.register.dto.UserDTO;
import org.pwr.register.mapper.UserMapper;
import org.pwr.register.model.User;
import org.pwr.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/register/")
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void register()
	{
		
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDTO> registerPOST(@RequestBody UserDTO userDTO)
	{
		if (userService.getUserByLogin(userDTO.getLogin()) == null && userService.registerUser(userMapper.map(userDTO)))
		{
			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<UserDTO>((UserDTO)null, HttpStatus.CONFLICT);
		}
	}
}
