package com.kausha.design.scheduler;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Singleton
public class ExecutedTaskRepository {
	// After the Job is executed, each job execution status is maintained for reference.
	// taskId - List<status>
	private static ExecutedTaskRepository repo = new ExecutedTaskRepository();
	
	ConcurrentMap<String, List<TaskResponse>> taskExecutionResponse = new ConcurrentHashMap<>();
	private ExecutedTaskRepository() {
		
	}
	public static ExecutedTaskRepository getInstance() {
		return repo;
	}
	
}
