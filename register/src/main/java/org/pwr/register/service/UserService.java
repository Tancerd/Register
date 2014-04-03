package org.pwr.register.service;

import java.util.List;

import org.pwr.register.dto.UserDTO;
import org.pwr.register.model.User;

public interface UserService {
	public User getUserById(Integer id);
	public User getUserByLogin(String login);
	public List getAllUsers();
	public boolean registerUser(User user);
	public boolean removeUser(String userName);
	public boolean updateUser(UserDTO user);
}
