package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.RefereeDAO;
import app.entities.Referee;

@Service
public class RefereeServiceImpl implements RefereeService {

	@Autowired
	private RefereeDAO refereeDAO;
	
	@Override
	@Transactional
	public List<Referee> getReferees() {
		return refereeDAO.getReferees();
	}

	@Override
	@Transactional
	public void saveReferee(Referee referee) {
		refereeDAO.saveReferee(referee);
	}

}
