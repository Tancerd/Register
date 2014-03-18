package org.pwr.register.service;

import java.util.List;

import org.pwr.register.dao.UserDAO;
import org.pwr.register.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public User getUserByLogin(String login) {
		return userDAO.findByLogin(login);
	}

	public List getAllUsers() {
		return userDAO.findAll();
	}

}
