package com.jetty.homolo.security.concurrent;

import com.jetty.homolo.security.entity.User;
import org.openjdk.jol.info.ClassLayout;

import java.math.BigDecimal;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 21:45 2019/11/28
 */
public class SyncTest {
    public static void main(String[] args) {
        String percent = getPercent(2L, 3L);
        System.out.println(percent);
    }

    private static String getPercent(Long readCount, Long totalCount) {
        if (totalCount == 0) {
            return "--";
        }
        BigDecimal totalBD = new BigDecimal(String.valueOf(totalCount));
        BigDecimal readBD = new BigDecimal(String.valueOf(readCount));
        return readBD.divide(totalBD, 4, BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal(100)).doubleValue() + "%";
    }
}
