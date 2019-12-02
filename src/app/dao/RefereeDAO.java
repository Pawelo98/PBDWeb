package app.dao;

import java.util.List;

import app.entities.Referee;

public interface RefereeDAO {

	public List<Referee> getReferees();

	public void saveReferee(Referee referee);
}
