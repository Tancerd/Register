package org.pwr.register.service;

import java.util.List;

import org.pwr.register.model.User;

public interface UserService {
	public User getUserById(Integer id);
	public List getAllUsers();
}
