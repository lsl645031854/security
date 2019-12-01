package com.jetty.homolo.security.concurrent.reentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 17:25 2019/11/30
 */
public class ParkTest {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(ParkTest::testSync);
        t.setName("t1");
        t.start();

        TimeUnit.SECONDS.sleep(2);

        System.out.println("主线程继续执行");
        LockSupport.unpark(t);

    }

    private static void testSync() {
        System.out.println(Thread.currentThread().getName());
        LockSupport.park(); //   线程阻塞
        System.out.println("唤醒");
    }

}
