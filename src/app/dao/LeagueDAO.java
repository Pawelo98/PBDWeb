package app.dao;

import java.util.List;

import app.entities.League;

public interface LeagueDAO {

	public List<League> getLeagues();

	public void saveLeague(League league);
}
