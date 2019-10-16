package com.jetty.homolo.security.lambda;

import com.jetty.homolo.security.entity.Dash;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 14:23 2019/10/16
 */
public class LambdaTest1 {
    private List<Dash> dashes = Arrays.asList(
            new Dash("番茄鸡蛋", 12.3, 400),
            new Dash("青椒鸡蛋", 10.8, 550),
            new Dash("苦瓜鸡蛋", 15.3, 510),
            new Dash("黄瓜鸡蛋", 18.3, 600)
    );
    private void println(List<Dash> dashes) {
        for (Dash dash : dashes) {
            System.out.println(dash);
        }
    }

    @Test
    public void test() {
        // 无参数 无返回值
        Runnable r = () -> {
            System.out.println("无参数 无返回值");
        };
        new Thread(r).run();

        Runnable r1 = () -> System.out.println("无参数 无返回值,只有一行语句，大括号可以省略");
        new Thread(r1).start();
    }

    @Test
    public void test2() {
        // 有参数，有返回值
        FilterDash<Dash> filterDash = (Dash dash) -> {
            System.out.println("进入表达体");
            return dash.getCalories() > 300;
        };
        boolean predicate = filterDash.predicate(new Dash("宫保鸡丁", 31d, 750));
        System.out.println(predicate);
    }

    @Test
    public void test3() {
        // 有参数，无返回值
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("测试……");
    }
}
