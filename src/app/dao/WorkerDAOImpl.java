package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.entities.Worker;

@Repository
public class WorkerDAOImpl implements WorkerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Worker> getWorkers() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Worker> query = session.createQuery("from Worker", Worker.class);
		
		List<Worker> workers = query.getResultList();
		
		return workers;
	}

	@Override
	public void saveWorker(Worker worker) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(worker);
	}

}
