package app.dao;

import java.util.List;

import app.entities.Club;

public interface ClubDAO {
	
	public List<Club> getClubs();

	public void saveClub(Club club);
}
