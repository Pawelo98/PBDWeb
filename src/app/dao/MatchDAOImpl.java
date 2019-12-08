package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.entities.Match; 

@Repository
public class MatchDAOImpl implements MatchDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Match> getMatches() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Match> query = session.createQuery("from Match", Match.class);
		
		List<Match> matches = query.getResultList();
		
		return matches;
	}

	@Override
	public void saveMatch(Match match) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(match);
	}
}
