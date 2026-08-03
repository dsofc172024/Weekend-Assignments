package io.assignments.threads;

//Program to thread-safe counter "without" using synchronized.?

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ThreadSafeCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicInteger counter = new AtomicInteger(0);
		ThreadSafeCounter obj = new ThreadSafeCounter();

		Runnable task = () -> {
			obj.task(counter);
		};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		Thread t3 = new Thread(task);
		Thread t4 = new Thread(task);
		Thread t5 = new Thread(task);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		try {
			//blocks main thread until 5 threads completes the execution
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			
	        System.out.println("Counter Value:: " + counter.get());
		} catch (Exception e) {
			System.out.println("Exception:: " + e.getMessage());
		}
	}

	public void task(AtomicInteger counter) {
		Stream.generate(counter::getAndIncrement).limit(10).forEach(System.out::println);
	}

}
