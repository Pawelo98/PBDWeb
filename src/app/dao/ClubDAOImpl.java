package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.entities.Club;

@Repository
public class ClubDAOImpl implements ClubDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Club> getClubs() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Club> query = session.createQuery("from Club", Club.class);
		
		List<Club> clubs = query.getResultList();
		
		return clubs;
	}

	@Override
	public void saveClub(Club club) {

		Session session = sessionFactory.getCurrentSession();
		
		session.save(club);
	}

}
