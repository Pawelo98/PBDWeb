package app.service;

import java.util.List;

import app.entities.Worker;

public interface WorkerService {
	
	public List<Worker> getWorkers();

	public void saveWorker(Worker worker);
}
