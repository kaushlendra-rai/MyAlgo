package com.kausha.design.scheduler;

public class Task implements Comparable<Task>{
	String taskId;
	String schedule; // Some pattern based on which the execution will be decided.
	
	String uri;
	String httpMethod;
	String mediaType;
	
	int priority; // High priority tasks will have a different pool for execution.
	
	byte[] payload;
	
	public int compare(Task first, Task second) {
		return first.priority - second.priority;
	}

	@Override
	public int compareTo(Task o) {
		return priority - o.priority;
	}
}
