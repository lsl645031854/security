package com.jetty.homolo.security.jdk8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @Author: lsl
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaTest2 {
    /**
     * () -> {}
     * 左侧：参数
     * 右侧：实现
     * lambda表达式需要函数式接口的支持
     * 函数式接口:接口中只有一个抽象方法的接口，重写的Object方法不属于抽象方法
     * lambda表达式数据类型可以省略不写，JVM可以根据上下文进行推断出来
     */
    @Test
    public void test() {
       //语法格式一: 无参数无返回值 ()  -> System.out.println("111");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
        new Thread(runnable).start();
        System.out.println("-------------------------------------");
        // 使用lambda
        Runnable rn = () -> System.out.println("hello world");
        rn.run();
    }

    @Test
    public void test2() {
        // 有一个参数，无返回值,左侧小括号可以省略不写
        Consumer<String> co = (String s) -> System.out.println(s);
        co.accept("测试lambda");
    }

    @Test
    public void test3() {
        // 有两个参数，有返回值，lambda体中有多条语句.，若存在多条语句，大括号和return可以省略
        Comparator<Integer> com = (x, y) -> {
            System.out.println("222");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test4() {
        Integer numValue = operation(100, num -> num * num);
        System.out.println(numValue);
    }
    private Integer operation(int num, MyFun mf) {
        return mf.operation(num);
    }
}
