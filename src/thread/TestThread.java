package thread;

public class TestThread {

	/**
	 * This Test class creates a deadlock.  :)
	 * @param args
	 */
	public static void main(String[] args) {
		WorkerClassA wca = new WorkerClassA();
		WorkerClassB wcb = new WorkerClassB();

		Thread thread1 = new Thread(new RunnableA(wca, wcb));
		
		Thread thread2 = new Thread(new RunnableB(wca, wcb));
		
		thread1.start();
		thread2.start();
	}
}