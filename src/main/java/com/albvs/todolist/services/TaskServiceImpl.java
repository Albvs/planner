package com.albvs.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albvs.todolist.dao.TaskRepository;
import com.albvs.todolist.model.Task;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskDAO;
	
	@Override
	public List<Task> findAllOrderByDateTimeAsc() {
		return taskDAO.findAllOrderByDateTimeAsc();
	}
	
	@Override
	public List<Task> findAllByGivenDate(String date) {
		return taskDAO.findAllByGivenDate(date);
	}
	
	@Override
	public List<Task> getAll() {
		return taskDAO.findAll();
	}

	@Override
	public Task getById(int id) {
		Optional<Task> result = taskDAO.findById(id);
		
		Task task = null;
		
		if(result.isPresent()) {
			task = result.get();
		}
		else {
			throw new RuntimeException("Did not find task id - " + id);
		}
		
		return task;
	}

	@Override
	public void save(Task task) {
		taskDAO.save(task);
	}

	@Override
	public void deleteById(int id) {
		taskDAO.deleteById(id);
	}

	
}
