package app.dao;

import java.util.List;

import app.entities.User;

public interface UserDAO {
	
	public List<User> getUsers();

	public void saveUser(User user);
	
}
