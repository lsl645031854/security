package com.jetty.homolo.security.stream;

import com.jetty.homolo.security.entity.Dash;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 21:33 2019/10/16
 */
public class StreamTest {
    private List<Dash> dashes = Arrays.asList(
            new Dash("番茄鸡蛋", 12.3, 400),
            new Dash("青椒鸡蛋", 10.8, 550),
            new Dash("苦瓜鸡蛋", 15.3, 510),
            new Dash("黄瓜鸡蛋", 18.3, 600)
    );

    @Test
    public void test() {
        Stream<Dash> stream = dashes.stream();

        Dash[] array = new Dash[3];
        Stream<Dash> stream1 = Arrays.stream(array);

        Stream<String> stringStream = Stream.of("aa", "bb", "cc");

    }


}
