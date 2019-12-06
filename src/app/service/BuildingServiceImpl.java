package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.BuildingDAO;
import app.entities.Building;

@Service
public class BuildingServiceImpl implements BuildingService {
	
	@Autowired
	private BuildingDAO buildingDAO;

	@Override
	@Transactional
	public List<Building> getBuildings() {
		return buildingDAO.getBuildings();
	}

	@Override
	@Transactional
	public void saveBuilding(Building building) {
		buildingDAO.saveBuilding(building);
	}

}
