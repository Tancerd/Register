package org.pwr.register.controllers.admin;

import java.util.List;

import org.pwr.register.dto.UserDTO;
import org.pwr.register.mapper.UserGameMapper;
import org.pwr.register.mapper.UserMapper;
import org.pwr.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * All Users, Delete user by login, Create user, Update user by login, 
 */
@Controller
@RequestMapping("/adminPanel")
public class AdminPanelUserController {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/deleteUser/{userName}", method = RequestMethod.DELETE)
	public @ResponseBody
	ResponseEntity<String> deleteUser(@PathVariable String userName) {
		if (userService.removeUser(userName)) {
			return new ResponseEntity<String>(userName, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>(userName,
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@RequestMapping(value = "/updateUser/{login}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<UserDTO> updateUser(@PathVariable String login,
			@RequestBody UserDTO user) {
		if (userService.updateUser(user, login)) {
			return new ResponseEntity<UserDTO>(user, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<UserDTO>(user, HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/createUser/", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
		if (userService.getUserByLogin(userDTO.getLogin()) == null
				&& userService.registerUser(userMapper.map(userDTO))) {
			return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<UserDTO>((UserDTO) null,
					HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/allUsers/")
	public @ResponseBody
	List<UserDTO> getAllUsers() {
		return userMapper.listMap(userService.getAllUsers());
	}

}
