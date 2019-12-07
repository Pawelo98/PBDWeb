package app.service;

import java.util.List;

import app.entities.League;

public interface LeagueService {
	public List<League> getLeagues();

	public void saveLeague(League league);
}
