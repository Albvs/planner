package com.albvs.todolist.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.albvs.todolist.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	
}
