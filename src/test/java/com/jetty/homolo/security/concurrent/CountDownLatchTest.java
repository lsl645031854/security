package com.jetty.homolo.security.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-12-02  下午12:38
 */
public class CountDownLatchTest {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CountDownLatch downLatch = new CountDownLatch(5);

		System.out.println("六点下班～");

		new Thread(() -> {
			try {
				downLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("我也可以下班了～");
		}).start();

		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				System.out.println("员工XXX下班了");
				downLatch.countDown();
			}).start();
		}
	}
}
