package thread;

public class RunnableA implements Runnable {

	WorkerClassA a = null;
	WorkerClassB b = null;
	
	public RunnableA(WorkerClassA wa, WorkerClassB wb)
	{
		a = wa;
		b = wb;
	}

	public void run() {
		b.setA(a);
		b.setAge(25);
	}

}
