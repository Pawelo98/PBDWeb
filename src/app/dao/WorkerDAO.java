package app.dao;

import java.util.List;

import app.entities.Worker;

public interface WorkerDAO {

	public List<Worker> getWorkers();

	public void saveWorker(Worker worker);
}
