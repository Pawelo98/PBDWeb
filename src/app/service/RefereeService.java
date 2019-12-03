package app.service;

import java.util.List;

import app.entities.Referee;

public interface RefereeService {
	
	public List<Referee> getReferees();

	public void saveReferee(Referee ref);
}
