package com.albvs.todolist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.albvs.todolist.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	@Query("from Task t order by t.dateTime asc")
	List<Task> findAllOrderByDateTimeAsc();
	
	@Query("from Task t where cast(t.dateTime as string) like :date% order by t.dateTime asc")
	List<Task> findAllByGivenDate(String date);
}
