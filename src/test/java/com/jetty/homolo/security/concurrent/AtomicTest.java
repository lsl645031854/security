package com.jetty.homolo.security.concurrent;

import org.checkerframework.checker.units.qual.A;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 22:02 2019/12/1
 */
public class AtomicTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < 100; i++) {
            service.execute(() -> atomicInteger.incrementAndGet());
        }

        service.shutdown();
        // 线程全部执行完成进行下一步操作.
        service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println(atomicInteger.get());
    }

}
