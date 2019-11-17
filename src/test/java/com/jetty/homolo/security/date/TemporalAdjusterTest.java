package com.jetty.homolo.security.date;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @Author: lsl
 * @Description: 时间校正器.
 * @Date: Created on 19:08 2019/11/17
 */
public class TemporalAdjusterTest {

    @Test
    public void test() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        ldt.withDayOfMonth(20);

        LocalDateTime monthStart = ldt.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(monthStart);
    }

    @Test
    public void test1() {

    }
}
