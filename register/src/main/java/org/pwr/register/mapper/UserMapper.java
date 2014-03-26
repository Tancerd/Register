package org.pwr.register.mapper;

import org.pwr.register.dto.UserDTO;
import org.pwr.register.model.User;
import org.pwr.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

	@Autowired
	private UserService userService;
	
	@Autowired 
	private GameUserMapper userGameMapper;
	
	
	//Rejestracja
	public User map(UserDTO userDTO)
	{
		User user = new User();
		user.setLogin(userDTO.getLogin());
		user.setPassword(userDTO.getPassword());
		user.setRole("ROLE_USER");
		user.setUserGame(null);
		return user;
	}
	/*
	public UserDTO map(String login)
	{
		User user = userService.getUserByLogin(login);
		UserDTO userDTO = new UserDTO();
		userDTO.setLogin(user.getLogin());
		userDTO.setPassword(null);
		userDTO.setUserGame(null);
		return userDTO;
	}
	*/
}
