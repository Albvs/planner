package com.albvs.todolist.services;

import java.time.LocalDate;
import java.util.List;

import com.albvs.todolist.model.Task;

public interface TaskService {
	public List<Task> findAllOrderByDateTimeAsc();
	public List<Task> findAllByGivenDate(LocalDate date);
	public List<Task> getAll();
	public Task getById(int id);
	public void save(Task task);
	public void deleteById(int id);
}
