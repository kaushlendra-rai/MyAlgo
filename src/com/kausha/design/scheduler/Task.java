package com.kausha.design.scheduler;

public class Task {
	String taskId;
	String schedule; // Some pattern based on which the execution will be decided.
	
	String uri;
	String httpMethod;
	String mediaType;
	
	int priority; // High priority tasks will have a different pool for execution.
	
	byte[] payload;
}
