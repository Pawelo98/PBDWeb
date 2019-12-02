package app.dao;

import java.util.List;

import app.entities.Building;

public interface BuildingDAO {
	
	public List<Building> getBuildings();

	public void saveBuilding(Building building);
}
