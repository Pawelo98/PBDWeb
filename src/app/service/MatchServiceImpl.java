package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.MatchDAO;
import app.entities.Match;

@Service
public class MatchServiceImpl implements MatchService {
	@Autowired
	private MatchDAO matchDAO;
	
	@Override
	@Transactional
	public List<Match> getMatches() {
		return matchDAO.getMatches();
	}

	@Override
	@Transactional
	public void saveMatch(Match match) {
		matchDAO.saveMatch(match);
	}

}
