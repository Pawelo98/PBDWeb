package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.entities.Referee;

@Repository
public class RefereeDAOImpl implements RefereeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Referee> getReferees() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Referee> query = session.createQuery("from Referee", Referee.class);
		
		List<Referee> users = query.getResultList();
		
		return users;
	}

	@Override
	public void saveReferee(Referee referee) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(referee);
	}

}
