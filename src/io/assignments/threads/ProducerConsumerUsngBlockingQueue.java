package io.assignments.threads;

//Program to show producer-consumer solution using "BlockingQueue".?

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerUsngBlockingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);
		AtomicInteger count = new AtomicInteger(0);
		System.out.println("Current count value:: " + count.get());

		ProducerConsumerUsngBlockingQueue obj = new ProducerConsumerUsngBlockingQueue();
		Thread producerThread = new Thread(() -> {
			obj.produce(queue, count);
		});
		producerThread.start();

		Thread consumerThread = new Thread(() -> {
			obj.consume(queue);
		});
		consumerThread.start();

	}

	public void produce(BlockingQueue<Integer> queue, AtomicInteger count) {

		while (true) {
			if (count.get() < 10) {
				try {
					// produced
					queue.put(count.incrementAndGet());
					System.out.println("Producer produced:: " + count.get());
				} catch (InterruptedException e) {
					System.out.println("Exception in producer!");
				}
			} else {
				try {
					queue.put(-1);
					break;
				} catch (InterruptedException e) {
					System.out.println("Exception in producer!");
				}
			}
		}

	}

	public void consume(BlockingQueue<Integer> queue) {

		while (true) {
			try {
				// consumed
				Integer val = queue.take().intValue();
				if (val == -1) {
					break;
				} else {
					System.out.println("Consumer consuming:: " + val.intValue());
				}
			} catch (InterruptedException e) {
				System.out.println("Exception in consumer!");
			}
		}

	}

}
