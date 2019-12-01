package com.jetty.homolo.security.jdk8.lambda;

import com.google.common.base.Function;
import com.jetty.homolo.security.entity.Dash;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Author: lsl
 * @Description: 方法引用和构造器引用.
 * @Date: Created on 15:48 2019/10/16
 */
public class LambdaTest3 {
    /**
     * 可以理解为方法引用是lambda的一中特例
     * 1、对象::实例方法
     * 2、类::静态方法
     * 3、类::实例方法
     */

    public static String method(String s) {
        return s;
    }

    private List<Dash> dashes = Arrays.asList(
            new Dash("番茄鸡蛋", 12.3, 400),
            new Dash("青椒鸡蛋", 10.8, 550),
            new Dash("苦瓜鸡蛋", 15.3, 510),
            new Dash("黄瓜鸡蛋", 18.3, 600)
    );
    @Test
    public void test() {
        // 对象::实例方法
        PrintStream out = System.out;
        Consumer<String> consumer = out::println;
        consumer.accept("厚德载物");

        Dash dash = new Dash("炒鸡蛋", 8d, 300);
        Supplier<String> getName = dash::getName;
        String s = getName.get();
        System.out.println(s);
    }

    @Test
    @SuppressWarnings("all")
    public void test1() {
        // 对象::静态方法
        Function<String, String> method1 = LambdaTest3::method;
        String apply = method1.apply("随便写一哈……");
        System.out.println(apply);
    }

    @Test
    public void test2() {
        Function<String, String> trim = String::trim;
        String apply = trim.apply("\t\t\t第三个  ");
        System.out.println(apply);
    }
    
}
