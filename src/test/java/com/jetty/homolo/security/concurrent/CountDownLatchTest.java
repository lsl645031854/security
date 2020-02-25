package com.jetty.homolo.security.concurrent;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-12-02  下午12:38
 */
public class CountDownLatchTest {

	private static final  ExecutorService executorService = Executors.newFixedThreadPool(10);


	@Test
	public void test() {
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

	@Test
	public void test1() throws Exception {
		final CountDownLatch downLatch = new CountDownLatch(1);

		new Thread(() -> {
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			downLatch.countDown();
			System.out.println("架构完成了");
		}).start();

		for (int i = 0; i < 5; i++) {
			System.out.println("等待架构");
			new Thread(() -> {
				try {
					downLatch.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("开始搬砖");
			}).start();
		}
	}
}
