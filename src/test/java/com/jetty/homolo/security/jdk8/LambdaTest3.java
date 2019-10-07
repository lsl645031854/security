package com.jetty.homolo.security.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author: lsl
 * @Description: 四大内置函数式接口
 * @Date: Created on 15:12 2019/10/5
 */
public class LambdaTest3 {

    @Test
    public void test1() {
        // 消费型接口 consume
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("厚德载物");

        MyFun mf = x -> x * 100;
        Integer num = mf.operation(100);
        System.out.println(num);
    }

    @Test
    public void test2() {
        // 供给型接口
        Random random = new Random();
        List<Integer> numList = getNumList(10, () -> random.nextInt(10));
        numList.forEach(System.out::println);
    }
    private List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer item = sup.get();
            list.add(item);
        }
        return list;
    }
    @Test
    public void test3() {
        // 函数型接口
        Function<String, String> function = s -> s.trim();
        String apply = function.apply("\t\t\tdad  ");
        System.out.println(apply);
    }

    @Test
    public void test4() {
        // 断言型接口
        Predicate<Integer> predicate = x -> (x * x) > 4;
        boolean test = predicate.test(5);
        System.out.println(test);
    }
}
