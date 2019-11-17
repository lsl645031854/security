package com.jetty.homolo.security.date;

import com.google.common.collect.Lists;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: lsl
 * @Description: Date时间时间类线程安全问题.
 * @Date: Created on 16:31 2019/11/17
 */
public class SimpleDateFormatTest {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> results = Lists.newArrayList();

        Callable<Date> call = () -> sdf.parse("20191117");

        for (int i = 0; i < 10; i++) {
            Future<Date> future = pool.submit(call);
            results.add(future);
        }

        results.stream().map(dateFuture -> {
            Date date = null;
            try {
                date = dateFuture.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return date;
        }).forEach(System.out::println);
//        results.stream().forEach(System.out::println);
        pool.shutdown();

    }
}
