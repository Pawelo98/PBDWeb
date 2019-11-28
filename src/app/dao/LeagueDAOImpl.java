package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.entities.League;

@Repository
public class LeagueDAOImpl implements LeagueDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<League> getLeagues() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<League> query = session.createQuery("from League", League.class);
		
		List<League> leagues = query.getResultList();
		
		return leagues;
	}

	@Override
	public void saveLeague(League league) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(league);
	}

}
