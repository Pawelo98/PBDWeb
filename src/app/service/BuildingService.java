package app.service;

import java.util.List;

import app.entities.Building;

public interface BuildingService {
	public List<Building> getBuildings();

	public void saveBuilding(Building building);
}
