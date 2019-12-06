package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.WorkerDAO;
import app.entities.Worker;

@Service
public class WorkerServiceImpl implements WorkerService {
	
	@Autowired
	private WorkerDAO workerDAO;
	
	@Override
	@Transactional
	public List<Worker> getWorkers() {
		return workerDAO.getWorkers();
	}

	@Override
	@Transactional
	public void saveWorker(Worker worker) {
		workerDAO.saveWorker(worker);
	}
}
