package com.kausha.design.scheduler;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

// This Task Scheduler runs every minute and fetches the task to be executed for next minute.
// Then, based on priority, schedules the tasks in appropriate executor.
public class TaskScheduler implements Runnable{
	TaskExecutor highPriorityTaskExecutor = new TaskExecutor();
	TaskExecutor taskExecutor = new TaskExecutor();
	
	// Alternatively, we can use PriorityQueue to maintain the Tasks based on their priority.
	// We then add and take tasks from this Priority Queue.
	// To avoid starvation for low priority tasks, we can keep decrementing the priority of tasks in every iteration to ensure that their
	// priority increases and eventually they get executed.
	//PriorityQueue<Task> queue = new PriorityQueue<>();
	
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
