package com.jetty.homolo.security.lambda;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 15:47 2019/10/16
 */
@FunctionalInterface
public interface MyFunction {
    String stringHandler(String s);

    static void doSome() {
        System.out.println("do some ...");
    }
}
