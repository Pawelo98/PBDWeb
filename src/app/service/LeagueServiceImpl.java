package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.LeagueDAO;
import app.entities.League;

@Service
public class LeagueServiceImpl implements LeagueService {
	
	@Autowired
	private LeagueDAO leagueDAO;
	
	@Override
	@Transactional
	public List<League> getLeagues() {
		return leagueDAO.getLeagues();
	}

	@Override
	@Transactional
	public void saveLeague(League league) {
		leagueDAO.saveLeague(league);
	}


}
