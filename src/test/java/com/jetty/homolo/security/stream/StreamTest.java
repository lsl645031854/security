package com.jetty.homolo.security.stream;

import com.jetty.homolo.security.entity.Dash;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: lsl
 * @Description: stream Api
 * @Date: Created on 21:33 2019/10/16
 */
public class StreamTest {
    private List<Dash> dashes = Arrays.asList(
            new Dash("番茄鸡蛋", 12.3, 400),
            new Dash("青椒鸡蛋", 10.8, 550),
            new Dash("苦瓜鸡蛋", 15.3, 510),
            new Dash("香菜鸡蛋", 15.3, 510),
            new Dash("黄瓜鸡蛋", 18.3, 600),
            new Dash("黄瓜鸡蛋", 18.3, 600),
            new Dash("黄瓜鸡蛋", 18.3, 600)
    );

    // 创建stream
    @Test
    public void test() {
        Stream<Dash> stream = dashes.stream();

        Dash[] array = new Dash[3];
        Stream<Dash> stream1 = Arrays.stream(array);

        Stream<String> stringStream = Stream.of("aa", "bb", "cc");
    }

    // 中间操作
    @Test
    public void test1() {
        // 筛选切片 filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        Stream<Dash> dashStream = dashes.stream().filter(dash -> dash.getCalories() > 500);
        dashStream.forEach(System.out::println);
    }
    @Test
    public void test2() {
        // 筛选切片
        Stream<Dash> dashStream = dashes.stream().filter(dash -> dash.getCalories() > 500);
        dashStream.skip(1).limit(1).forEach(System.out::println);
    }
    @Test
    public void test3() {
        // distinct()——筛选去重，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        Stream<Dash> dashStream = dashes.stream().filter(dash -> dash.getCalories() == 600);
        dashStream.distinct().forEach(System.out::println);
    }

    @Test
    public void test4() {
//      map(Function f)——接收 Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，
//      该函数会被应用到每个元素上，并将其映射成一个新的元素。
//      <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);
//      <R> Stream<R> map(Function<? super T, ? extends R> mapper);
        dashes.stream().distinct().map(Dash::getName).forEach(System.out::println);

        List<List<String>> lists = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b","c", "d"));
        Function<List<String>, Stream<String>> function = list -> list.stream();
        Stream<String> stringStream = lists.stream().flatMap(Collection::stream);
        stringStream.forEach(System.out::println);
    }
    @Test
    public void test5() {
      // sorted()——自然排序
      // sorted(Comparator com)——定制排序
      dashes.stream().distinct().sorted().forEach(System.out::println);
      System.out.println("------------------------------");
      dashes.stream().sorted((Dash d1, Dash d2) -> {
            if (d1.getCalories().equals(d2.getCalories())) {
                return d1.getName().compareTo(d2.getName()) ;
            } else {
                return d1.getCalories().compareTo(d2.getCalories());
            }
        }).forEach(System.out::println);
    }
    // 终止操作
    // 1- 查找与匹配
    //allMatch(Predicate p)——检查是否匹配所有元素
    //anyMatch(Predicate p)——检查是否至少匹配一个元素
    //noneMatch(Predicate p)——检查是否没有匹配的元素
    //findFirst——返回第一个元素
    //findAny——返回当前流中的任意元素
    //count——返回流中元素的总个数
    //max(Comparator c)——返回流中最大值
    //min(Comparator c)——返回流中最小值
    //forEach(Consumer c)——内部迭代
    @Test
    public void test6() {
        boolean b = dashes.stream().anyMatch(dash -> dash.getCalories() == 510);
        System.out.println(b);
        boolean b1 = dashes.stream().allMatch(dash -> !dash.getName().equals(""));
        System.out.println(b1);
        Optional<Integer> max = dashes.stream().map(Dash::getCalories).max(Integer::compare);
        System.out.println(max.get());

        Optional<Dash> min = dashes.stream().min(Comparator.comparingInt(Dash::getCalories));
        System.out.println(min.get());
    }
//    归约
//    reduce(T identity, BinaryOperator)——可以将流中元素反复结合起来，得到一个值。返回 T
//    reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
    @Test
    public void test7() {
        List<Integer> list = Arrays.asList(1,2,3);
        Optional<Integer> reduce = list.stream().reduce((x, y) -> x + y);
        System.out.println(reduce.get());

        Integer reduce1 = list.stream().reduce(0, (x, y) -> x*x + y*y);
        System.out.println(reduce1);
        System.out.println("==========================");
        Optional<Integer> sum = dashes.stream().distinct().map(Dash::getCalories).reduce(Integer::sum);
        System.out.println(sum.get());
    }
//  3-收集
//  collect(Collector c)——将流转换为其他形式。接收一个 Collector接口的实现，
//                      用于给Stream中元素做汇总的方法
    @Test
    public void test8() {
        List<Integer> list = dashes.stream().map(Dash::getCalories).collect(Collectors.toCollection(ArrayList::new));
        int sum = dashes.stream().mapToInt(Dash::getCalories).sum();
        // 获取总数
        long count = dashes.stream().count();
        // 获取平均数
        Double ave = dashes.stream().collect(Collectors.averagingInt(Dash::getCalories));
        // 分组
        Map<Integer, List<Dash>> group = dashes.stream().collect(Collectors.groupingBy(Dash::getCalories));
        System.out.println(group);
    }

    @Test
    public void test9() {
       List<String> list = Arrays.asList("a", "b", "c", "d");
        String join = String.join(",", list);
        System.out.println(join);

        String collect = list.stream().collect(Collectors.joining(",", "==", "=="));
        System.out.println(collect);
    }

    @Test
    public void test10() {
        List<Integer> list = Arrays.asList(2,3);
        Integer reduce = list.stream().reduce(0, (x, y) -> x * x + y * y);
        System.out.println(reduce);
    }
}
