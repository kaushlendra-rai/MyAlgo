package com.kausha.design.scheduler;

public class ExecutableTask implements Runnable{
	//RestTemplate template; to be used to actually invoke the REST APIs
	Task task;
	ExecutedTaskRepository executedTaskRepo;
	public ExecutableTask(Task task) {
		this.task = task;
		executedTaskRepo = ExecutedTaskRepository.getInstance(); 
	}
	public void run() {
		// Execute the REST API invocation in this block using REST Template.
		
		// This run method must also update the task execution status after execution or timeout appropriately. 
		
		// It MUST also update the DB with the next schedule of execution so that the time based query works as expected.
	}

}
