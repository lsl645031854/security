package com.jetty.homolo.security.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-10-08  上午10:17
 */
public class LockTest {
	private ReentrantLock lock = new ReentrantLock();

	private void doSomething() {
//		lock.lock();
//		if (lock.tryLock(4000, TimeUnit.SECONDS)) {
//			Thread.sleep(2000);//为看出执行效果，是线程此处休眠2秒
		try {
			lock.lockInterruptibly();
			System.out.println(Thread.currentThread().getName() + "获取锁");
			System.out.println(Thread.currentThread().getName() + "执行任务");
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " : " + i);
			}
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + "获取锁时发生异常");
		} finally {
			try {
				lock.unlock();
				System.out.println(Thread.currentThread().getName() + "释放锁");
			} catch (Exception e) {
				System.out.println(Thread.currentThread().getName() + "释放锁异常");
			}
		}
//		} else {
//			System.out.println(Thread.currentThread().getName() + "无法获取锁");
//		}
	}

	public static void main(String[] args) {
		LockTest test = new LockTest();
		Runnable r = () -> {
			test.doSomething();
		};
		new Thread(r).start();

		Runnable r1 = () -> {
			test.doSomething();

		};
		Thread thread = new Thread(r1);
		thread.start();
		thread.interrupt();
	}
}
