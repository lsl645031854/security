package com.jetty.homolo.security.date;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: lsl
 * @Description: Date时间时间类线程安全问题.
 * @Date: Created on 16:31 2019/11/17
 */
public class SimpleDateFormatTest1 {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> results = Lists.newArrayList();

        Callable<Date> call = () -> DateFormatThreadLocal.convert("20191117");

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

        String s = String.valueOf(null);
        System.out.println(s);

    }
}
