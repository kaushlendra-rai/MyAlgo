package thread;

public class WorkerClassA {

	private static int age = 29;

	WorkerClassB b = null;

	public void setB(WorkerClassB b) {
		this.b = b;
	}

	public synchronized void setAge(int num) {
		age = num;
		
		System.out.println("@@@WorkerClassA:setAge - Age set to " + age);
		try
		{
			// Simulating some processing
			System.out.println("@@@WorkerClassA:setAge - Going to Sleep for 5000 ms");
			Thread.sleep(5000);
		}
		catch(Throwable t)
		{}
		System.out.println("@@@WorkerClassA:setAge - Slept for 5000 ms");
		
		b.setAge(12);
		
		System.out.println("@@@WorkerClassA:setAge - Age set to 12");
	}
}