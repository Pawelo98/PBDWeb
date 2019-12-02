package app.dao;

import java.util.List;

import app.entities.Match;

public interface MatchDAO {

	public List<Match> getMatches();

	public void saveMatch(Match match);
}
