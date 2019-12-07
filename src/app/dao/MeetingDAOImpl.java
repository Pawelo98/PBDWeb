package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.entities.Meeting;

@Repository
public class MeetingDAOImpl implements MeetingDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Meeting> getMeetings() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Meeting> query = session.createQuery("from Meeting", Meeting.class);
		
		List<Meeting> meetings = query.getResultList();
		
		return meetings;
	}

	@Override
	public void saveMeeting(Meeting meeting) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(meeting);
	}
}
