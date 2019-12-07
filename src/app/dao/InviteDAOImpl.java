package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.entities.Invite;

@Repository
public class InviteDAOImpl implements InviteDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Invite> getInvites() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Invite> query = session.createQuery("from Invite", Invite.class);
		
		List<Invite> invites = query.getResultList();
		
		return invites;
	}

	@Override
	public void saveInvite(Invite invite) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(invite);
	}
}
