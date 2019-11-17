package com.jetty.homolo.security.date;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: lsl
 * @Description: LocalDate时间时间类线程安全问题.
 * @Date: Created on 16:31 2019/11/17
 */
public class LocalDateTest {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

        List<Future<LocalDate>> results = Lists.newArrayList();

        Callable<LocalDate> call = () -> LocalDate.parse("20191117", dtf);

        for (int i = 0; i < 10; i++) {
            Future<LocalDate> future = pool.submit(call);
            results.add(future);
        }

        results.stream().map(dateFuture -> {
            LocalDate localDate = null;
            try {
                localDate = dateFuture.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return localDate;
        }).forEach(System.out::println);
//        results.stream().forEach(System.out::println);
        pool.shutdown();
    }

    @Test
    public void test() {
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        System.out.println(ld);
        System.out.println(lt);

        LocalDateTime localDateTime = ldt.plusMonths(1);
        System.out.println(localDateTime);
    }

    @Test
    public void test1() {
        Instant instant = Instant.now();
        System.out.println(instant);

        long epochMilli = instant.toEpochMilli();
        System.out.println(epochMilli);
    }

    @Test
    public void test2() throws InterruptedException {
        // 计算两个时间之间的间隔
        Instant in1 = Instant.now();
        TimeUnit.SECONDS.sleep(1);
        Instant in2 = Instant.now();
        Duration duration = Duration.between(in1, in2);
        System.out.println(duration.toMillis());
        System.out.println("----------------------------");
        // 计算两个日期之间的间隔
        LocalDate ld1 = LocalDate.of(2019, 11, 17);
        LocalDate ld2 = LocalDate.of(2020, 12, 1);
        Period period = Period.between(ld1, ld2);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());


    }

    @Test
    public void test3() {

    }
}
