package org.pwr.register.mapper;

import java.util.ArrayList;
import java.util.List;

import org.pwr.register.dto.UserDTO;
import org.pwr.register.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
	
	@Autowired 
	private UserGameMapper userGameMapper;
	
	
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
	
	public UserDTO map(User user)
	{
		UserDTO userDTO = new UserDTO();
		userDTO.setLogin(user.getLogin());
		userDTO.setPassword(null);
		userDTO.setUserGame(userGameMapper.map(user.getUserGame()));
		return userDTO;
	}
	
	public List<UserDTO> listMap(List<User> list) {
		List<UserDTO> listDTO = new ArrayList<UserDTO>();
		for (User user : list) {
			listDTO.add(map(user));
		}
		return listDTO;
	}
	
}
