package app.service;

import java.util.List;

import app.entities.Club;

public interface ClubService {

	public List<Club> getClubs();

	public void saveClub(Club club);
}
