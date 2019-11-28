package app.service;

import java.util.List;

import app.entities.League;
import app.entities.User;

public interface UserService {
	
	public List<User> getUsers();
	
	public List<League> getLeagues();

	public void saveUser(User user);
	
	public void saveLeague(League league);
}
