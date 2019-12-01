package com.jetty.homolo.security.concurrent.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 11:20 2019/11/30
 */
public class ReentrantLockTest {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        lock.lock();

        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        new Thread(r).start();
    }


}
