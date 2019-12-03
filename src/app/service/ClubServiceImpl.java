package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.ClubDAO;
import app.entities.Club;

@Service
public class ClubServiceImpl implements ClubService {

	@Autowired
	private ClubDAO clubDAO;
	
	@Override
	@Transactional
	public List<Club> getClubs() {
		return clubDAO.getClubs();
	}

	@Override
	@Transactional
	public void saveClub(Club club) {
		clubDAO.saveClub(club);
	}

}
