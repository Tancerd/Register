package org.pwr.register.controllers;

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
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void isAdminLogged()
	{
		
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> registerPOST(@RequestBody User user)
	{
		if (userService.getUserByLogin(user.getLogin()) == null && userService.registerUser(user))
		{
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
		else
		{
		return new ResponseEntity<User>((User)null, HttpStatus.CONFLICT);
		}
	}
}
