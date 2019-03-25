package thread;

public class WorkerClassB {

	private static int age = 29;
	
	WorkerClassA a = null;

	public void setA(WorkerClassA a) {
		this.a = a;
	}

	public synchronized void setAge(int num) {
		age = num;
		
		System.out.println("###WorkerClassB:setAge - Age set to " + age);
		try
		{
			System.out.println("###WorkerClassB:setAge - Going to Sleep for 5000 ms");
			Thread.sleep(5000);
		}
		catch(Throwable t)
		{}
		System.out.println("###WorkerClassB:setAge - Slept for 5000 ms");
		
		a.setAge(12);
		
		System.out.println("###WorkerClassB:setAge - Age set to 12");
	}
}