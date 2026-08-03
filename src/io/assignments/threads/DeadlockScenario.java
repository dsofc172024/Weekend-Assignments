package io.assignments.threads;

//Program for showing "deadlock" scenario.?

public class DeadlockScenario {

	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();

		DeadlockScenario deadlock = new DeadlockScenario();
		Thread t1 = new Thread(() -> {
			deadlock.method1(obj1, obj2);
		});

		Thread t2 = new Thread(() -> {
			deadlock.method2(obj1, obj2);
		});

		t1.start();
		t2.start();

	}

	public void method1(Object obj1, Object obj2) {
		synchronized (obj1) {
			System.out.println("Object lock 1 acquired by Method 1");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("Trying to acquire Object lock 2 in Method 1...");
			synchronized (obj2) {
				System.out.println("Object lock 2 acquired by Method 1");
			}

		}
	}

	public void method2(Object obj1, Object obj2) {
		synchronized (obj2) {
			System.out.println("Object lock 2 acquired by Method 2");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Trying to acquire Object lock 1 in Method 2...");
			synchronized (obj1) {
				System.out.println("Object lock 1 acquired by Method 2");
			}
		}
	}

}
