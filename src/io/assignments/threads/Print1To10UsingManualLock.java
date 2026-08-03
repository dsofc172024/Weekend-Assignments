package io.assignments.threads;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Print1To10UsingManualLock {

	private final ReentrantLock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();

	public static void main(String[] args) {

		Print1To10UsingManualLock obj = new Print1To10UsingManualLock();

		AtomicInteger counter = new AtomicInteger(1);

		Thread oddThread = new Thread(() -> obj.printOdd(counter));
		Thread evenThread = new Thread(() -> obj.printEven(counter));

		oddThread.start();
		evenThread.start();

	}

	public void printOdd(AtomicInteger counter) {

		while (true) {

			lock.lock();

			try {

				while (counter.get() <= 10 && counter.get() % 2 == 0) {
					condition.await();
				}

				if (counter.get() > 10) {
					condition.signalAll();
					break;
				}

				System.out.println("Thread "+Thread.currentThread().getId() + " :: " + counter.getAndIncrement());

				condition.signalAll();

			} catch (Exception e) {
				System.out.println("Exception in printOdd!");
			} finally {
				lock.unlock();
			}
		}
	}

	public void printEven(AtomicInteger counter) {

		while (true) {

			lock.lock();

			try {

				while (counter.get() <= 10 && counter.get() % 2 != 0) {
					condition.await();
				}

				if (counter.get() > 10) {
					condition.signalAll();
					break;
				}

				System.out.println("Thread "+Thread.currentThread().getId() + " :: " + counter.getAndIncrement());

				condition.signalAll();

			} catch (Exception e) {
				System.out.println("Exception in printEven!");
			} finally {
				lock.unlock();
			}
		}
	}
}