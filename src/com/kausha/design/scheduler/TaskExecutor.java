package com.kausha.design.scheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskExecutor {
	ThreadPoolExecutor executor;
	
	public TaskExecutor() {
		executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		executor.setCorePoolSize(10);
		executor.setMaximumPoolSize(50);
		executor.setKeepAliveTime(500, TimeUnit.MILLISECONDS);
	}
	
	public void execute(ExecutableTask task) {
		executor.execute(task);
	}
}
