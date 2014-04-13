package org.pwr.register.serviceImpl;

import java.util.List;

import org.pwr.register.dao.UserDAO;
import org.pwr.register.dto.UserDTO;
import org.pwr.register.model.User;
import org.pwr.register.service.UserService;
import org.pwr.register.support.MD5;
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
		user.setPassword(MD5.getHash(user.getPassword()));
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

	public boolean updateUser(UserDTO userData, String login) {
		User user = userDAO.findByLogin(login);
		if (user != null && userDAO.findByLogin(userData.getLogin()) == null) {
			return userDAO.saveOrUpdate(user, userData);
		}
		return false;
	}

}
