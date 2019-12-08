package app.service;

import java.util.List;

import app.entities.Match;

public interface MatchService {
	public List<Match> getMatches();

	public void saveMatch(Match match);
}
