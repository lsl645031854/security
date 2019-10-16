package com.jetty.homolo.security.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 16:27 2019/10/7
 */
public class StreamTest {
    //创建stream
    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream(); //collection系列集合提供的stream()

        String[] array = new String[10];
        Stream<String> stream1 = Arrays.stream(array); //方式二

        Stream<String> stream2 = Stream.of("aa", "bb", "cc"); //方式三

        // 创建无限流
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        iterate.limit(2).forEach(System.out::println);

        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(2).forEach(System.out::println);
    }


}
