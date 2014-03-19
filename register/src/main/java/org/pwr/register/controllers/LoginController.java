package org.pwr.register.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/login/")
public class LoginController {

	@RequestMapping
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void login()
	{
		
	}
}
