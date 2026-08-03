package io.assignments.threads;

//Program to print numbers 1 to 100 alternately using three threads showing odd thread,
//even thread & sum thread.?

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Print1To100 {

	private static final Object lock = new Object();

	private static final int ODD = 0;
	private static final int EVEN = 1;
	private static final int SUM = 2;

	public static void main(String[] args) throws InterruptedException {

		AtomicInteger counter = new AtomicInteger(1);
		AtomicInteger sum = new AtomicInteger(0);
		AtomicInteger lastPrintedSum = new AtomicInteger(0);

		AtomicInteger turn = new AtomicInteger(ODD);

		AtomicBoolean completed = new AtomicBoolean(false);

		int limit = 100;

		Print1To100 printer = new Print1To100();

		Thread odd = new Thread(() -> printer.printOdd(counter, sum, turn, completed, limit));
		Thread even = new Thread(() -> printer.printEven(counter, sum, turn, completed, limit));
		Thread sumThread = new Thread(() -> 
			printer.printSum(counter, sum, lastPrintedSum, turn, completed, limit));

		odd.start();
		even.start();
		sumThread.start();

		odd.join();
		even.join();
		sumThread.join();

		System.out.println("Total Sum :: " + sum.get());
	}

	private void printOdd(AtomicInteger counter, AtomicInteger sum, AtomicInteger turn, AtomicBoolean completed,
			int limit) {

		while (true) {

			synchronized (lock) {

				// wait if turn is not odd and still counter has not reached 100
				while (turn.get() != ODD && !completed.get()) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}

				// loop break logic
				if (counter.get() > limit) {
					completed.set(true);
					lock.notifyAll();
					break;
				}

				int value = counter.getAndIncrement();
				sum.addAndGet(value);
				System.out.println(Thread.currentThread().getId() + " -> " + value);
				turn.set(EVEN);
				lock.notifyAll();
			}
		}
	}

	private void printEven(AtomicInteger counter, AtomicInteger sum, AtomicInteger turn, AtomicBoolean completed,
			int limit) {

		while (true) {

			synchronized (lock) {

				while (turn.get() != EVEN && !completed.get()) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}

				if (counter.get() > limit) {
					completed.set(true);
					lock.notifyAll();
					break;
				}

				int value = counter.getAndIncrement();
				sum.addAndGet(value);
				System.out.println(Thread.currentThread().getId() + " -> " + value);
				turn.set(SUM);
				lock.notifyAll();
			}
		}
	}

	private void printSum(AtomicInteger counter, AtomicInteger sum, AtomicInteger lastPrintedSum, AtomicInteger turn,
			AtomicBoolean completed, int limit) {

		while (true) {

			synchronized (lock) {

				while (turn.get() != SUM && !completed.get()) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}

				// loop break logic
				if (counter.get() > limit) {
					completed.set(true);
					lock.notifyAll();
					break;
				}
				
				System.out.println(Thread.currentThread().getId() + " -> Current Sum:: " + sum.get());
				turn.set(ODD);
				lock.notifyAll();
			}
		}
	}
}