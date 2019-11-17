package com.jetty.homolo.security.jdk8;

import com.jetty.homolo.security.entity.Dash;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @Author: lsl
 * @Description: 容器类.
 * @Date: Created on 13:44 2019/11/10
 */
public class OptionalTest {

    @Test
    public void test() {
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.get());
    }

    @Test
    public void test1() {
        Optional<Object> optional = Optional.ofNullable(null);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
        System.out.println(optional.orElseGet(Dash::new));
        System.out.println(optional.orElse("22222"));
    }

    @Test
    public void test2() {
        Supplier<Dash> supplier = Dash::new;
        Optional<Dash> op = Optional.ofNullable(new Dash());
        Optional<String> s = op.map(Dash::getName);
        System.out.println(s);
    }
}
