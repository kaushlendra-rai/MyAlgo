package com.kausha.design.scheduler;

import java.util.Date;
import java.util.List;

// This Task Scheduler runs every minute and fetches the task to be executed for next minute.
// Then, based on priority, schedules the tasks in appropriate executor.
public class TaskScheduler implements Runnable{
	TaskExecutor highPriorityTaskExecutor = new TaskExecutor();
	TaskExecutor taskExecutor = new TaskExecutor();
	TaskRepository rep;
	
	public TaskScheduler(TaskRepository rep) {
		this.rep = rep;
	}
	
	public void run(){
		//  
		List<Task> tasks = getScheduledTasks();
		// Based on the task priority, execute the task in appropriate task executor.
		for(Task task : tasks) {
			ExecutableTask executableTask = new ExecutableTask(task);
			if(task.priority < 5)
				highPriorityTaskExecutor.execute(executableTask);
			else
				taskExecutor.execute(executableTask);
		}
	}
	
	// Get all tasks to be scheduled next minute.
	
	private List<Task> getScheduledTasks(){
		Date date = new Date();
		date.setMinutes(date.getMinutes() +1);
		
		return null;
	}
	
}
