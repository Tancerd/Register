package org.pwr.register.service;

import java.util.List;

import org.pwr.register.dao.UserDAO;
import org.pwr.register.dto.UserDTO;
import org.pwr.register.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public User getUserById(Integer id) {
		return userDAO.findById(id);
	}

	public List getAllUsers() {
		return userDAO.findAll();
	}

	public boolean registerUser(User user) {
		return userDAO.save(user);
	}

	public User getUserByLogin(String login) {
		return userDAO.findByLogin(login);
	}

	public boolean removeUser(String userName) {
		User user = userDAO.findByLogin(userName);
		if (user != null) {
			return userDAO.delete(user);
		}
		return false;
	}

	public boolean updateUser(UserDTO userData) {
		User user = userDAO.findByLogin(userData.getLogin());
		System.out.print("sadadasdasdass" + userData);
		if (user != null) {
			return userDAO.saveOrUpdate(user, userData);
		}
		return false;
	}

}
