package com.kausha.design.scheduler;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

//Singleton
public class TaskRepository {
	ConcurrentMap<String, Task> tasks = new ConcurrentHashMap<>();
	private TaskRepository taskRepo = new TaskRepository();
	
	private TaskRepository() {
		 
	}
	
	public TaskRepository getInstance() {
		return taskRepo;
	}
}
