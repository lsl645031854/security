package com.jetty.homolo.security.concurrent;

import com.jetty.homolo.security.entity.User;
import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 21:45 2019/11/28
 */
public class SyncTest {
    public static void main(String[] args) {
        User user = new User();
        String s = ClassLayout.parseClass(user.getClass()).toPrintable();
        System.out.println(s);
    }
}
