package thread;

public class RunnableB implements Runnable {

	WorkerClassA a = null;
	WorkerClassB b = null;
	
	public RunnableB(WorkerClassA wa, WorkerClassB wb)
	{
		a = wa;
		b = wb;
	}
	
	public void run() {
		a.setB(b);
		a.setAge(22);
	}

}
