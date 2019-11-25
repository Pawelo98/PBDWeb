package app.service;

import java.util.List;

import app.entities.User;

public interface UserService {
	
	public List<User> getUsers();

	public void saveUser(User user);
}
