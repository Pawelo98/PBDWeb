package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.entities.Building;

@Repository
public class BuildingDAOImpl implements BuildingDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Building> getBuildings() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Building> query = session.createQuery("from Building", Building.class);
		
		List<Building> clubs = query.getResultList();
		
		return clubs;
	}

	@Override
	public void saveBuilding(Building building) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(building);
	}

}
