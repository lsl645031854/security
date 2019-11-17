package com.jetty.homolo.security.lambda;

import com.jetty.homolo.security.entity.Dash;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: lsl
 * @Description: 方法引用和构造器引用
 * @Date: Created on 15:42 2019/11/5
 */
public class ReferenceTest {

    @Test
    public void test1() {
        Supplier<Dash> supplier = Dash::new;
        supplier.get();
    }

    @Test
    public void test2() {
        PrintStream printStream = System.out;
        Consumer<String> consumer = printStream::println;
        consumer.accept("实例方法引用");
    }

    @Test
    public void test3() {
        // 静态方法引用.
        List<Integer> list = Arrays.asList(2, 3, 4, 1, 22, 33, 11, 12);
        Comparator<Integer> comparator = Integer::compare;

        list.sort(comparator);
        list.forEach(System.out::println);
    }

    @Test
    public void test4() {
        // 某个类型的任意对象的实例方法引用
        Function<String, String> function = String::toUpperCase;
        String s = function.apply("reference");
        System.out.println(s);
    }
}
